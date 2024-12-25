class Solution {
    List<List<Integer>> permutation = new ArrayList<>();
    List<Integer> currPermutation = new ArrayList<>();
    boolean[] visited;
    int[] elements;

    public List<List<Integer>> permute(int[] nums) {
        elements = nums;
        visited = new boolean[nums.length];
        backtrack(0);
        return permutation;
    }

    private void backtrack(int index) {
        if (index == elements.length) {
            permutation.add(new ArrayList<>(currPermutation));
            return;
        }

        for (int j = 0; j < elements.length; ++j) {
            if (!visited[j]) {
                visited[j] = true;
                currPermutation.add(elements[j]);
                backtrack(index + 1);
                currPermutation.remove(currPermutation.size() - 1);
                visited[j] = false;
            }
        }
    }
}