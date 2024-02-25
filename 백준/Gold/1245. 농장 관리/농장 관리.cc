#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int arr[100][70];
bool visited[100][70];
int N, M;
int dx[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
int dy[8] = {0, 0, -1, 1, 1, -1, -1, 1};

bool isMountainTop(int x, int y, int height);

int main() {
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
        }
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (!visited[i][j]) {
                if (isMountainTop(i, j, arr[i][j])) {
                    answer++;
                }
            }
        }
    }

    cout << answer;
}

bool isMountainTop(int x, int y, int height) {
    queue<pair<int, int>> q;
    q.push(make_pair(x, y));
    visited[x][y] = true;
    bool isTop = true;
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for (int i = 0; i < 8; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (arr[nx][ny] > height) isTop = false;
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] == height) {
                q.push(make_pair(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    if (isTop) {
        return true;
    }
    return false;
};

