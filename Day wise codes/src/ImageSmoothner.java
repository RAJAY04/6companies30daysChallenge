public class ImageSmoothner {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] res = imageSmoother(image);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmoother(int[][] img) {
        int n = img.length, m = img[0].length;
        int[][] res = new int[n][m];
        int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };
        int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
        for (int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++){
                int average = 0;
                int size = 0;
                for(int k = 0; k < 8; k++ ){
                    int row = (i + dx[k]) , col = (j + dy[k]);
                    if(row < 0 || col < 0 || row >= n || col >= m)continue;
                    average += img[row][col];
                    size++;
                }
                average += img[i][j];
                size++;
                res[i][j] = (int) Math.floor((double)average/size);
            }

        }
        return res;
    }
}
