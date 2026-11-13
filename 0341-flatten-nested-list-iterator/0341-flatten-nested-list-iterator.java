public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        // Push elements in reverse order so the first element is processed first
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // hasNext() ensures the top of the stack is an Integer
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            
            // If the top element is an integer, we are ready
            if (curr.isInteger()) {
                return true;
            }
            
            // If it's a list, pop it and push its contents in reverse order
            stack.pop();
            List<NestedInteger> list = curr.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }
}