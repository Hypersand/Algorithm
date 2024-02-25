#include <iostream>
#include <queue>

using namespace std;

char arr[5][5];
bool used[25] = {false,};
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
int answer = 0;

void bfs() {
    queue<pair<int, int>> q;
    bool visited[5][5] = {false,}; //방문 여부
    bool visited2[5][5] = {false,}; //조합으로 뽑은 좌표
    int x, y;
    for (int i = 0; i < 25; i++) {
        if (used[i]) {
            x = i / 5;
            y = i % 5;
            visited2[x][y] = true;
        }
    }

    int sCnt = 0;
    int yCnt = 0;
    q.push(make_pair(x, y));
    visited[x][y] = true;
    if (arr[x][y] == 'Y') {
        yCnt++;
    } else {
        sCnt++;
    }

    int cnt = 1;
    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];
            if (nx < 0 || ny < 0 || nx >=5 || ny >= 5) continue;
            if (!visited2[nx][ny]) continue; //조합으로 뽑지 않은 좌표면 넘어감
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] == 'S') {
                sCnt++;
            }
            q.push(make_pair(nx, ny));
            visited[nx][ny] = true;
            cnt++;
        }
    }

    //조건 만족
    if (cnt == 7 && sCnt >= 4) {
        answer++;
    }
};

void comb(int idx, int length) {
    if (length == 7) {
        bfs();
        return;
    }

    for (int i = idx; i < 25; i++) {
        if (!used[i]) {
            used[i] = true;
            comb(i + 1, length + 1);
            used[i] = false;
        }
    }
};

int main() {
    for (int i = 0; i < 5; i++) {
        string line;
        cin >> line;
        for (int j = 0; j < 5; j++) {
            arr[i][j] = line.at(j);
        }
    }

    comb(0, 0);
    cout << answer;
}




