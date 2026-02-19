// class MyHashSet {
//        private HashSet<Integer> set;

//     public MyHashSet() {
//         set= new HashSet<>();

//     }
    
//     public void add(int key) {
//       set.add(key);
//     }
    
//     public void remove(int key) {
//         set.remove(key);
//     }
    
//     public boolean contains(int key) {
//         return set.contains(key);
//     }
// }
class MyHashSet {
    private List<Integer> list;

    public MyHashSet() {
        list = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!list.contains(key)) list.add(key);
    }
    
    public void remove(int key) {
        list.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */