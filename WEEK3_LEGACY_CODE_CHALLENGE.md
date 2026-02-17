# 🐞 Bug Buster's Legacy Code Modernization Challenge - Week 3

## Challenge Submission for GitHub Copilot Skills Series

**Submitted by:** @vikashkumar016  
**Persona:** Bug Buster 🐞  
**Focus:** Modernizing legacy code while preventing bugs  
**Date:** February 2026

---

## 📋 Challenge Answers

### Question 1: When modernizing legacy code with GitHub Copilot, what should be your first priority?

**Answer: b) Understanding the existing functionality and creating tests before refactoring**

**Bug Buster Reasoning:**

Refactoring without tests is like **debugging blindfolded** - you can't tell if you introduced new bugs.

**Why This Prevents Bugs:**

1. **Tests Document Behavior**
   - Captures edge cases the original code handles
   - Prevents breaking hidden functionality
   - Acts as safety net during refactoring

2. **Understanding Prevents Mistakes**
   - Legacy code often has non-obvious bug fixes embedded
   - Quick rewrites lose institutional knowledge
   - Edge case handling might look like bugs but isn't

3. **Test-First Refactoring**
   - Write tests for current behavior (even if buggy)
   - Refactor incrementally
   - Tests fail → you broke something
   - Tests pass → refactoring safe

**Bug Buster Approach:**

```
Step 1: Analyze legacy code - what does it actually do?
Step 2: Write tests for current behavior (bugs and all)
Step 3: Identify bugs vs features
Step 4: Refactor with tests as safety net
Step 5: Add tests for new edge cases
Step 6: Fix identified bugs with test coverage
```

**Example: Hidden Edge Case**

```javascript
// Legacy code - looks buggy but handles edge case
function processAmount(amount) {
    // Why the weird check? Looks like a bug...
    if (amount == 0) {  // Weak comparison
        return null;
    }
    return amount * 1.1;
}

// ❌ Quick "fix" without understanding:
function processAmount(amount) {
    return amount * 1.1;  // BREAKS: processAmount(0) now returns 0 not null
}

// Turns out downstream code depends on null for zero amounts!
// Without tests, this silent bug reaches production.

// ✅ Test-first approach:
test('processAmount returns null for zero', () => {
    expect(processAmount(0)).toBe(null);  // This test would fail!
});

// Now we know the behavior is intentional
// Refactor safely:
function processAmount(amount) {
    if (amount === 0) {  // Modernize to strict equality
        return null;      // Keep the intended behavior
    }
    return amount * 1.1;
}
```

**Why Other Options Fail:**

- **a) Rewrite from scratch** → Loses edge case handling, introduces new bugs
- **c) Update syntax immediately** → Breaks without understanding dependencies
- **d) Remove documentation** → Loses context, guarantees future bugs

**Bug Prevention Checklist Before Refactoring:**

```
□ Do we have tests for current behavior?
□ Have we documented what the code actually does?
□ Do we understand why it was written this way?
□ Are there edge cases we might miss?
□ What are the dependencies on this code?
□ Can we refactor incrementally with safety nets?
```

---

### Question 2: GitHub Copilot suggests converting callbacks to async/await. What factors should you consider?

**Answer: d) All of the above**

**Bug Buster Reasoning:**

Converting callbacks to async/await changes **error flow** - one of the biggest sources of bugs in refactoring.

**Critical Factors (All Matter for Bug Prevention):**

**a) Codebase async/await support**

```javascript
// Legacy callback code
function fetchUser(id, callback) {
    db.query('SELECT * FROM users WHERE id = ?', [id], callback);
}

// ❌ Converting ONE function creates inconsistency:
async function fetchUser(id) {
    return await db.query('SELECT * FROM users WHERE id = ?', [id]);
}

// Now other code breaks:
getUserProfile(userId, function(err, profile) {
    // This expects callback pattern but fetchUser is now async
    fetchUser(profile.userId, function(err, user) {  
        // BREAKS: fetchUser doesn't accept callbacks anymore!
    });
});

// ✅ Must convert consistently or maintain both patterns:
async function fetchUserAsync(id) {
    return await db.query('SELECT * FROM users WHERE id = ?', [id]);
}

// Keep legacy version for backwards compatibility
function fetchUser(id, callback) {
    fetchUserAsync(id)
        .then(result => callback(null, result))
        .catch(err => callback(err));
}
```

**b) Error handling impact**

```javascript
// Legacy callback - error-first pattern
function processData(input, callback) {
    validateInput(input, function(err, valid) {
        if (err) return callback(err);  // Error handling here
        
        transformData(valid, function(err, transformed) {
            if (err) return callback(err);  // And here
            
            callback(null, transformed);
        });
    });
}

// ❌ Naive async conversion loses error context:
async function processData(input) {
    const valid = await validateInput(input);      // Throws generic error
    const transformed = await transformData(valid); // Context lost!
    return transformed;
}

// ✅ Proper error handling preservation:
async function processData(input) {
    try {
        const valid = await validateInput(input);
        const transformed = await transformData(valid);
        return transformed;
    } catch (error) {
        // Maintain error context
        throw new Error(`Data processing failed: ${error.message}`);
    }
}

// 🐞 Watch for unhandled promise rejections:
processData(userInput);  // BUG: No .catch() or try/catch
// This silently fails in some Node versions!

// ✅ Always handle promises:
processData(userInput).catch(err => console.error(err));
```

**c) Runtime version compatibility**

```javascript
// async/await requires:
// - Node.js 7.6+ (or transpilation)
// - Modern browsers

// ❌ Deploying to Node 6 environment:
async function fetchData() {  // SYNTAX ERROR on Node 6
    return await db.query('...');
}

// Production server crashes on startup!

// ✅ Check before refactoring:
// - What's the deployment environment?
// - Can we upgrade runtime?
// - Do we need transpilation (Babel)?
// - Are CI/CD tests running on correct version?
```

**Bug Buster Checklist for Callback → Async/Await:**

```
□ Is the entire call chain ready for async/await?
□ Have we wrapped all async calls in try/catch?
□ Are promise rejections handled everywhere?
□ Does deployment environment support async/await?
□ Have we tested error scenarios specifically?
□ Are there timeouts to prevent hanging promises?
□ Do we handle concurrent async operations correctly?
□ Have we checked for race conditions?
```

**Real Bug Example:**

```javascript
// Legacy code with race condition protection
let processingUser = null;

function loadUser(id, callback) {
    if (processingUser === id) {
        return callback(new Error('Already processing'));
    }
    processingUser = id;
    
    db.query('...', function(err, user) {
        processingUser = null;
        callback(err, user);
    });
}

// ❌ Async conversion loses race protection:
async function loadUser(id) {
    processingUser = id;  // Can be overwritten before await returns!
    const user = await db.query('...');
    processingUser = null;
    return user;
}

// Fast double-click → two concurrent requests → race condition

// ✅ Maintain protection:
const processingUsers = new Set();

async function loadUser(id) {
    if (processingUsers.has(id)) {
        throw new Error('Already processing');
    }
    
    processingUsers.add(id);
    try {
        const user = await db.query('...');
        return user;
    } finally {
        processingUsers.delete(id);  // Always cleanup
    }
}
```

---

### Question 3: Refactoring a 500-line function. What's the recommended approach?

**Answer: b) Break it down into smaller, testable functions with single responsibilities**

**Bug Buster Reasoning:**

**Large functions = Bug breeding grounds**

**Why 500-Line Functions Are Dangerous:**

1. **Hard to Debug**
   - Can't isolate where bugs occur
   - Multiple responsibilities mask root cause
   - Stack traces point to mega-function (not helpful)

2. **Impossible to Test**
   - Can't test individual behaviors
   - Edge cases interact in unexpected ways
   - Mock/stub hell for dependencies

3. **Easy to Introduce Bugs**
   - Variable reuse across logic blocks
   - Shared state mutations
   - Long functions = lost context = mistakes

**Bug Buster Refactoring Strategy:**

```javascript
// ❌ BEFORE: 500-line monster function
function processOrder(order) {
    // Lines 1-50: Validate order
    if (!order) return null;
    if (!order.items) return null;
    if (!order.customer) return null;
    // ... 47 more validation lines
    
    // Lines 51-150: Calculate totals
    let subtotal = 0;
    for (let i = 0; i < order.items.length; i++) {
        // ... complex calculation logic
        // ... discount logic
        // ... tax logic
    }
    
    // Lines 151-250: Apply promotions
    // ... nested if/else for promotion rules
    
    // Lines 251-350: Check inventory
    // ... database calls
    // ... stock validation
    
    // Lines 351-450: Payment processing
    // ... credit card validation
    // ... payment gateway calls
    
    // Lines 451-500: Generate invoice
    // ... PDF generation
    // ... email sending
    
    return result;
}

// 🐞 BUGS HIDING IN THIS MONSTER:
// - Variable 'i' reused in multiple loops (collision risk)
// - Error in line 300 requires reading entire function
// - Can't test "calculate totals" without full order processing
// - Changing tax logic might break payment processing (shared state)
```

**✅ AFTER: Single Responsibility Functions**

```javascript
/**
 * Process an order through validation, calculation, and fulfillment
 * @param {Object} order - Order to process
 * @returns {Object} Processed order with invoice
 * @throws {Error} If validation or processing fails
 */
async function processOrder(order) {
    // Each step is testable, debuggable, maintainable
    const validatedOrder = validateOrder(order);
    const pricedOrder = calculateOrderTotals(validatedOrder);
    const discountedOrder = applyPromotions(pricedOrder);
    await checkInventoryAvailability(discountedOrder);
    const payment = await processPayment(discountedOrder);
    const invoice = await generateInvoice(discountedOrder, payment);
    
    return { order: discountedOrder, payment, invoice };
}

// Each function is focused, testable, debuggable

/**
 * Validate order structure and required fields
 * @param {Object} order - Order to validate
 * @returns {Object} Validated order
 * @throws {ValidationError} If order is invalid
 */
function validateOrder(order) {
    if (!order) {
        throw new ValidationError('Order cannot be null');
    }
    
    if (!order.items || order.items.length === 0) {
        throw new ValidationError('Order must have at least one item');
    }
    
    if (!order.customer || !order.customer.id) {
        throw new ValidationError('Order must have valid customer');
    }
    
    // Validate each item
    order.items.forEach((item, index) => {
        if (!item.productId) {
            throw new ValidationError(`Item ${index} missing productId`);
        }
        if (!item.quantity || item.quantity <= 0) {
            throw new ValidationError(`Item ${index} has invalid quantity`);
        }
    });
    
    return order;
}

/**
 * Calculate order totals including tax
 * @param {Object} order - Validated order
 * @returns {Object} Order with calculated totals
 */
function calculateOrderTotals(order) {
    const subtotal = order.items.reduce((sum, item) => {
        return sum + (item.price * item.quantity);
    }, 0);
    
    const tax = calculateTax(subtotal, order.customer.region);
    const total = subtotal + tax;
    
    return {
        ...order,
        subtotal,
        tax,
        total
    };
}

/**
 * Apply eligible promotions to order
 * @param {Object} order - Order with totals
 * @returns {Object} Order with discounts applied
 */
function applyPromotions(order) {
    let discount = 0;
    
    // Check each promotion rule
    if (order.subtotal > 100) {
        discount += order.subtotal * 0.1;  // 10% off
    }
    
    if (order.customer.isVIP) {
        discount += 5;  // $5 VIP bonus
    }
    
    const total = order.total - discount;
    
    return {
        ...order,
        discount,
        total
    };
}

// Now each function:
// ✅ Does ONE thing (single responsibility)
// ✅ Is testable independently
// ✅ Has clear inputs/outputs
// ✅ Is easy to debug (small scope)
// ✅ Can be modified without breaking others
```

**Testing Benefits:**

```javascript
// ✅ Can test each function independently

test('validateOrder throws for missing items', () => {
    expect(() => validateOrder({ customer: {} }))
        .toThrow('Order must have at least one item');
});

test('calculateOrderTotals computes correct tax', () => {
    const order = {
        items: [{ price: 10, quantity: 2 }],
        customer: { region: 'CA' }
    };
    
    const result = calculateOrderTotals(order);
    
    expect(result.subtotal).toBe(20);
    expect(result.tax).toBe(2);  // 10% tax
    expect(result.total).toBe(22);
});

test('applyPromotions gives 10% off orders over $100', () => {
    const order = {
        subtotal: 150,
        total: 150,
        customer: { isVIP: false }
    };
    
    const result = applyPromotions(order);
    
    expect(result.discount).toBe(15);
    expect(result.total).toBe(135);
});

// With the 500-line function, you'd need to mock EVERYTHING
// to test one piece of logic. Now each test is simple!
```

**Debugging Benefits:**

```javascript
// ❌ With 500-line function:
// Error: Cannot read property 'price' of undefined
//   at processOrder (line 87)
// 
// Now you read 500 lines to find which item is undefined

// ✅ With small functions:
// Error: Cannot read property 'price' of undefined
//   at calculateOrderTotals (line 12)
//
// 12 lines to read, clear context, easy fix
```

**Why Other Options Fail:**

- **a) Copilot rewrites everything** → Loses edge cases, introduces new bugs
- **c) Update variable names only** → Still unmaintainable, bugs still hiding
- **d) Add comments without refactoring** → Lipstick on a pig, still buggy

---

### Question 4: Copilot suggests replacing deprecated methods. What should you verify first?

**Answer: a) That the new methods are backwards compatible with your deployment environment**

**Bug Buster Reasoning:**

**Deprecated ≠ Broken**  
**Modern ≠ Compatible**

Deploying incompatible code = **production crashes** = critical bugs

**Real-World Bug Example:**

```javascript
// Legacy code using deprecated method
const crypto = require('crypto');

function hashPassword(password) {
    // crypto.createCipher deprecated in Node 10
    // Still works in Node 8, 9, 10, 11, 12...
    const cipher = crypto.createCipher('aes192', 'secret-key');
    let encrypted = cipher.update(password, 'utf8', 'hex');
    encrypted += cipher.final('hex');
    return encrypted;
}

// Copilot suggests modern alternative:
function hashPassword(password) {
    // Uses crypto.createCipheriv (recommended)
    const algorithm = 'aes-256-cbc';
    const key = crypto.scryptSync('secret-key', 'salt', 32);
    const iv = crypto.randomBytes(16);
    
    const cipher = crypto.createCipheriv(algorithm, key, iv);
    let encrypted = cipher.update(password, 'utf8', 'hex');
    encrypted += cipher.final('hex');
    
    return { encrypted, iv: iv.toString('hex') };
}

// ❌ BUGS INTRODUCED:
// 1. Return type changed (string → object)
//    - All existing code breaks: user.password === hashPassword(input)
// 2. IV not stored = can't decrypt existing passwords
//    - All existing users locked out!
// 3. scryptSync only available Node 10.5+
//    - Crashes on Node 10.0-10.4 in production

// Production deployment on Node 10.2:
// Error: crypto.scryptSync is not a function
// Entire auth system down!
```

**Bug Buster Verification Checklist:**

```
□ What Node/runtime version is in production?
□ What version do CI/CD tests run on?
□ Does the new method exist in that version?
□ Does it have the same behavior/return type?
□ Can we maintain backwards compatibility?
□ Do we have a rollback plan if it breaks?
□ Have we tested on the actual deployment environment?
```

**Safe Migration Strategy:**

```javascript
// ✅ Step 1: Check environment compatibility
function getNodeVersion() {
    const version = process.versions.node.split('.');
    return {
        major: parseInt(version[0]),
        minor: parseInt(version[1])
    };
}

// ✅ Step 2: Feature detection, not version checking
function hashPassword(password) {
    // Use modern method if available, fallback to legacy
    if (crypto.scryptSync) {
        // Modern Node 10.5+
        return hashPasswordModern(password);
    } else {
        // Legacy Node 8-10.4
        return hashPasswordLegacy(password);
    }
}

// ✅ Step 3: Gradual migration with compatibility layer
function hashPasswordLegacy(password) {
    const cipher = crypto.createCipher('aes192', 'secret-key');
    let encrypted = cipher.update(password, 'utf8', 'hex');
    encrypted += cipher.final('hex');
    return encrypted;  // Same return type
}

function hashPasswordModern(password) {
    const algorithm = 'aes-256-cbc';
    const key = crypto.scryptSync('secret-key', 'salt', 32);
    const iv = crypto.randomBytes(16);
    
    const cipher = crypto.createCipheriv(algorithm, key, iv);
    let encrypted = cipher.update(password, 'utf8', 'hex');
    encrypted += cipher.final('hex');
    
    // Return same format as legacy for compatibility
    return encrypted;  // Store IV separately in this version
}

// ✅ Step 4: Deploy with fallback, monitor, then remove legacy
```

**More Examples:**

```javascript
// Array.prototype.includes (ES2016)
// Copilot suggests modernizing:

// Legacy code (works everywhere)
if (array.indexOf(item) !== -1) {
    // ...
}

// Modern suggestion
if (array.includes(item)) {
    // ...
}

// ❌ BUG: Breaks on IE11, old Safari, Node < 6
// Production analytics page crashes for 15% of users!

// ✅ Check browser support first:
// Can we drop IE11?
// Do we have polyfills?
// What's the user browser distribution?
```

**Why Other Options Are Wrong:**

- **b) Most popular on Stack Overflow** → Popularity ≠ compatibility
- **c) Deprecated method still works** → Until it doesn't (future Node versions)
- **d) Team approval of syntax** → Doesn't prevent production crashes

**Bug Prevention:**

```javascript
// Add to CI/CD pipeline:
// 1. Test on minimum supported Node version
// 2. Test on production-equivalent environment
// 3. Feature detection tests
// 4. Compatibility smoke tests

// .github/workflows/test.yml
strategy:
  matrix:
    node: [10.0, 10.5, 12, 14, 16]  # Test all supported versions

// Tests fail on Node 10.0 → catch before production
```

---

### Question 5: How can GitHub Copilot best assist with improving legacy code documentation?

**Answer: b) By generating comprehensive docstrings, inline comments, and updating README files based on the refactored code**

**Bug Buster Reasoning:**

**Poor documentation = Future bugs**

When developers don't understand code:
- They make wrong assumptions
- They break edge cases
- They introduce bugs fixing "bugs" that aren't bugs
- They duplicate functionality

**Why Comprehensive Documentation Prevents Bugs:**

**1. Docstrings Define Contracts**

```javascript
// ❌ No documentation - bugs waiting to happen
function processPayment(amount, card) {
    if (amount <= 0) return null;
    if (!card.valid) return null;
    return charge(amount, card);
}

// Future developer:
const result = processPayment(100, userCard);
if (result) {
    // Success! ...or is it?
}

// 🐞 BUGS:
// - What does null mean? Error? Zero amount? Invalid card?
// - What if amount is string "100"?
// - What fields does card need?
// - Does this throw errors or return null?
// - What is the return value format?

// ✅ Comprehensive docstring prevents bugs:
/**
 * Process a payment transaction
 * 
 * @param {number} amount - Payment amount in cents (must be positive integer)
 * @param {Object} card - Credit card object
 * @param {string} card.number - Card number (will be validated)
 * @param {string} card.cvv - 3-digit security code
 * @param {string} card.expiry - Expiry in MM/YY format
 * 
 * @returns {Object|null} Transaction object on success, null on validation failure
 * @returns {string} return.transactionId - Unique transaction ID
 * @returns {number} return.amount - Charged amount in cents
 * @returns {Date} return.timestamp - Transaction timestamp
 * 
 * @throws {PaymentError} If payment gateway fails
 * @throws {NetworkError} If connection fails
 * 
 * @example
 * const result = processPayment(10000, {
 *   number: '4111111111111111',
 *   cvv: '123',
 *   expiry: '12/25'
 * });
 * 
 * if (result === null) {
 *   // Validation failed (amount <= 0 or invalid card)
 * } else {
 *   // Success - result.transactionId available
 * }
 */
function processPayment(amount, card) {
    // Input validation (as documented)
    if (!Number.isInteger(amount) || amount <= 0) {
        return null;
    }
    
    if (!isValidCard(card)) {
        return null;
    }
    
    // May throw PaymentError or NetworkError (as documented)
    return charge(amount, card);
}

// Now developers know:
// ✅ amount must be positive integer (not string, not float)
// ✅ null = validation failure, exception = processing error
// ✅ Exact card object structure required
// ✅ What the return value contains
// ✅ How to handle errors vs validation failures
```

**2. Inline Comments Explain "Why" (Prevent "Fix" Bugs)**

```javascript
// ❌ No comments - looks like a bug
function calculateShipping(weight) {
    if (weight < 0) {
        weight = 0;  // WTF? Why?
    }
    
    return weight * 5 + 10;
}

// Future developer "fixes" the "bug":
function calculateShipping(weight) {
    if (weight < 0) {
        throw new Error('Weight cannot be negative');  // "Fixed"!
    }
    
    return weight * 5 + 10;
}

// 🐞 PRODUCTION BUG:
// Returns weight can be negative (customer return)
// Old code handled it gracefully (free return shipping)
// "Fix" crashes checkout for all returns!

// ✅ Inline comment prevents "fix":
function calculateShipping(weight) {
    // Returns (negative weight) get free shipping
    // This is intentional business logic, not a bug
    if (weight < 0) {
        weight = 0;
    }
    
    return weight * 5 + 10;
}

// Now future developer understands intent
```

**3. README Updates Prevent Integration Bugs**

```markdown
❌ Outdated README:

## Authentication

Call `auth.login(username, password)` to authenticate.

---

Meanwhile, code was refactored:

```javascript
// Now requires email, not username
async function login(email, password) { ... }
```

// 🐞 New developer follows outdated docs:
auth.login(username, password);  // BREAKS - username not email!

---

✅ Updated README after refactoring:

## Authentication

**Changed in v2.0:** Now uses email instead of username.

```javascript
// Old (deprecated, remove by v3.0)
auth.login(username, password, callback);

// New (async/await with email)
const user = await auth.login(email, password);
```

### Migration Guide

If you're using username-based login:

```javascript
// Before:
auth.login(user.username, password, callback);

// After:
const user = await auth.login(user.email, password);
```

### Breaking Changes

- `login()` now async (returns Promise)
- First parameter is email (not username)
- Callback removed (use async/await or .then())
```

Now integration bugs prevented!
```

**Why Other Options Fail:**

- **a) Remove all comments** → Guaranteed future bugs from misunderstanding
- **c) Only TODO comments** → Doesn't explain current code behavior
- **d) Copy from other projects** → Wrong context, misleading, causes bugs

**Bug Buster Documentation Checklist:**

```
□ Every public function has JSDoc/docstring
□ Parameters documented (type, constraints, examples)
□ Return values documented (type, possible values)
□ Errors/exceptions documented (what throws, when)
□ Edge cases explained in comments
□ "Why" comments for non-obvious logic
□ README updated with API changes
□ Migration guide for breaking changes
□ Examples show common usage patterns
```

---

## 🚀 My Legacy Code Transformation

### Before & After: Authentication System Modernization

**🐞 BEFORE: Legacy Callback-Based Auth (2015)**

```javascript
// Legacy callback-based user authentication
function authenticateUser(username, password, callback) {
    var user = null;
    
    // 🐞 BUG #1: SQL Injection vulnerability
    db.query("SELECT * FROM users WHERE username = '" + username + "'", function(err, results) {
        // 🐞 BUG #2: No error handling
        user = results[0];
        
        // 🐞 BUG #3: No null check - crashes if user not found
        // 🐞 BUG #4: Weak comparison == instead of ===
        if (user.password == password) {
            // 🐞 BUG #5: No error parameter in callback (inconsistent pattern)
            callback(user);
        } else {
            // 🐞 BUG #6: Silent failure - returns null, hard to debug
            callback(null);
        }
    });
}

// 🐞 BUG #7: Callback hell - error-prone, unmaintainable
authenticateUser(req.body.username, req.body.password, function(user) {
    if (user) {
        getUserProfile(user.id, function(profile) {
            getRecentActivity(user.id, function(activity) {
                sendResponse(user, profile, activity);
            });
        });
    }
});
```

**🐞 BUGS IDENTIFIED:**

1. **SQL Injection** (line 6) - Critical security vulnerability
2. **No error handling** (line 7) - Silent crashes, no debugging info
3. **No null/undefined checks** (line 10) - Runtime crash if user not found
4. **Weak comparison `==`** (line 10) - Type coercion bugs ('' == 0 is true!)
5. **Inconsistent callback pattern** (line 11) - Doesn't follow error-first convention
6. **Silent failure** (line 13) - Returns null, impossible to distinguish failure types
7. **Callback hell** (lines 18-24) - Error propagation broken, unmaintainable
8. **No input validation** - Empty strings, null values, SQL injection all possible
9. **Plain text password** - Security disaster, passwords stored unhashed

---

**✅ AFTER: Modernized with Bug Buster + Copilot**

```javascript
/**
 * Authenticate user with modern async/await pattern
 * 
 * @param {string} username - User's username (will be trimmed and lowercased)
 * @param {string} password - User's password (will be hashed for comparison)
 * 
 * @returns {Promise<Object>} Authenticated user object
 * @returns {number} return.id - User ID
 * @returns {string} return.username - Username
 * @returns {string} return.email - User email
 * 
 * @throws {ValidationError} If username or password is invalid format
 * @throws {AuthenticationError} If credentials don't match
 * @throws {DatabaseError} If database query fails
 * 
 * @example
 * try {
 *   const user = await authenticateUser('john_doe', 'secret123');
 *   console.log(`Welcome ${user.username}`);
 **

