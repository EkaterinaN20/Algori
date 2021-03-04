public class ReverseString {

        public String revert(String s) {
            StackImpl<Character> stack = new StackImpl();
            char[] charArray = s.toCharArray();
            char[] var4 = charArray;
            int var5 = charArray.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                char c = var4[var6];
                stack.push(c);
            }

            StringBuilder sb = new StringBuilder();

            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            System.out.println(sb);
            return sb.toString();
        }
}
