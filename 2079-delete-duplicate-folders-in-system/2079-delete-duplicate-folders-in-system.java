class Solution {

    // Trie Node Definition
    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String name;
        String serial = "";
        boolean toDelete = false;

        TrieNode(String name) {
            this.name = name;
        }
    }

    // Root of the Trie
    TrieNode root = new TrieNode("");

    // Map to detect duplicate subtrees
    Map<String, Integer> freqMap = new HashMap<>();

    // Step 1: Build the Trie from paths
    public void insert(String[] path) {
        TrieNode node = root;
        for (String folder : path) {
            node.children.putIfAbsent(folder, new TrieNode(folder));
            node = node.children.get(folder);
        }
    }

    // Step 2: Serialize each subtree (Post-order DFS)
    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        // Sort children to ensure consistent serialization order
        List<String> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            TrieNode child = node.children.get(key);
            sb.append("(").append(key).append(serialize(child)).append(")");
        }

        node.serial = sb.toString();
        freqMap.put(node.serial, freqMap.getOrDefault(node.serial, 0) + 1);
        return node.serial;
    }

    // Step 3: Mark nodes to delete if duplicate
    private void markDuplicates(TrieNode node) {
        if (freqMap.getOrDefault(node.serial, 0) > 1) {
            node.toDelete = true;
        }
        for (TrieNode child : node.children.values()) {
            markDuplicates(child);
        }
    }

    // Step 4: Collect valid paths from non-deleted nodes
    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (!child.toDelete) {
                path.add(child.name);
                result.add(new ArrayList<>(path));
                collectPaths(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Build Trie from input paths
        for (List<String> path : paths) {
            insert(path.toArray(new String[0])); // ✅ Array used here
        }

        serialize(root);           // ✅ Serialization = String + Hash Function
        markDuplicates(root);      // ✅ Hash Table used here
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result); // ✅ Array used again

        return result;
    }
}
