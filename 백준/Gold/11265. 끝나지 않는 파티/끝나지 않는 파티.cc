#include <iostream>

using namespace std;

int main() {
    long INF = 10000000000;
    int N, M;
    cin >> N >> M;
    long arr[N+1][N+1];
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 0) {
                arr[i][j] = INF;
            }
        }
    }

    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][k] + arr[k][j] < arr[i][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }

    for (int i = 0; i < M; i++) {
        int A, B, C;
        cin >> A >> B >> C;
        if (arr[A][B] <= C) {
            cout << "Enjoy other party\n";
        } else {
            cout << "Stay here\n";
        }
    }

    return 0;
}