import java.util.*;
import java.io.*;

class ls {

  public static void main(String[] args) throws Exception {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    String regex = in.readLine();
    String[] regStrs = regex.replaceAll("\\*", " ").trim().split(" ");
    int lastRegStrLength = regStrs[regStrs.length - 1].length();
    boolean lastRegCharNotAsterix = regex.charAt(regex.length() - 1) != '*';

    int N = Integer.parseInt(in.readLine());
    StringBuilder sb = new StringBuilder();

    while (N-- != 0) {
      String filename = in.readLine();
      int diffLength = filename.length() - lastRegStrLength;
      if (lastRegCharNotAsterix && diffLength > 0
          && !filename.substring(diffLength).equals(regStrs[regStrs.length - 1])) {
        continue;
      }
      boolean isMatch = true;
      int index = -1;
      for (String regStr : regStrs) {
        int regStrIndex = filename.indexOf(regStr, index + 1);
        if (regStrIndex != -1) {
          index = regStrIndex;
        } else {
          isMatch = false;
          break;
        }
      }
      if (isMatch) {
        sb.append(filename).append('\n');
      }
    }

    out.print(sb);

    in.close();
    out.close();
  }

}