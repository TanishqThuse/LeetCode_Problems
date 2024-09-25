//Nice qsn --> Practise again
class Trie {
    Trie[] children = new Trie[26];
    int count = 0;

    Trie() {
    }

    void insert(Trie root, String s) {
        Trie curr = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new Trie();
            curr = curr.children[idx];
            curr.count++;
        }
        return;
    }

    int search(Trie root, String s) {
        Trie curr = root;
        int n = s.length(), current = 0;
        for (int i = 0; i < n; ++i) {
            int idx = s.charAt(i) - 'a';
            curr = curr.children[idx];
            if (curr.count == 1)
                return current + n - i;
            current += curr.count;
        }
        return current;
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int n = words.length, idx = 0;
        int[] ans = new int[n];
        Trie root = new Trie();
        for (int i = 0; i < n; i++)
            trie.insert(root, words[i]);

        for (int i = 0; i < n; i++)
            ans[idx++] = trie.search(root, words[i]);
        return ans;
    }
}   