import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] arr = new int[9][9];
    private static List<Point> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        backTracking(0);

    }

    private static void backTracking(int idx) {
        if (idx == list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        for (int i = 1; i < 10; i++) {
            if (validate(list.get(idx).x, list.get(idx).y, i)) {
                arr[list.get(idx).x][list.get(idx).y] = i;
                backTracking(idx + 1);
                arr[list.get(idx).x][list.get(idx).y] = 0;
            }
        }

    }

    //(x,y)에 value를 넣을 수 있는지 검증한다.
    private static boolean validate(int x, int y, int value) {
        //행, 열 검증
        for (int i = 0; i < 9; i++) {
            if (arr[i][y] == value) {
                return false;
            }
            if (arr[x][i] == value) {
                return false;
            }
        }

        //3X3 사각형 검증
        if (x <= 2) {
            if (y <= 2) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            } else if (y <= 5) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 3; j <= 5; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            } else {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 6; j <= 8; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            }


        } else if (x <= 5) {
            if (y <= 2) {
                for (int i = 3; i <= 5; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            } else if (y <= 5) {
                for (int i = 3; i <= 5; i++) {
                    for (int j = 3; j <= 5; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            } else {
                for (int i = 3; i <= 5; i++) {
                    for (int j = 6; j <= 8; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            }

        } else {
            if (y <= 2) {
                for (int i = 6; i <= 8; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            } else if (y <= 5) {
                for (int i = 6; i <= 8; i++) {
                    for (int j = 3; j <= 5; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;

            } else {
                for (int i = 6; i <= 8; i++) {
                    for (int j = 6; j <= 8; j++) {
                        if (arr[i][j] == value) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }

    }
}
