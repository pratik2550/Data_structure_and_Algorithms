package Codechef_06_21;
/*
    Shortest Route to reach destination station:- https://www.codechef.com/JUNE21C/problems/SHROUTE
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestRoute {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().trim().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        String station[] = br.readLine().trim().split(" ");
        String passenger[] = br.readLine().trim().split(" ");

        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = Integer.parseInt(station[i]);

        int[] b = new int[m];
        for (int i=0; i<m; i++) b[i] = Integer.parseInt(passenger[i]);

        int ans[] = new int[n];
        int left = -1, right = -1;
        int max = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            if (i==0 || a[i]!=0) ans[i] = 0;
            else ans[i] = max;
        }

        for (int i=0; i<n; i++) {
            if (ans[i]==1) right = i;
            if (right!=-1)
                if (ans[i]!=0) ans[i] = Math.min(ans[i], i-right);
        }

        for (int i=n-1; i>=0; i--) {
            if (ans[i]==2) left = i;
            if (left!=-1)
                if (ans[i]!=0) ans[i] = Math.min(ans[i], left-i);
        }

        for (int i=0; i<m; i++) {
            int j = b[i]-1;
            if (ans[j]!=max)
                System.out.print(ans[j]+" ");
            else
                System.out.print(-1+" ");
        }
        System.out.println();
    }
}
