#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    // Read input
    int n;
    cin >> n;
    
    vector<pair<int, int>> cards;
    for (int i = 1; i <= n; ++i) {
        int value;
        cin >> value;
        cards.push_back({i, value});
    }

    // Sort the cards
    sort(cards.begin(), cards.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        return a.second < b.second;
    });

    // Print pairs
    for (int i = 0; i < n / 2; ++i) {
        cout << cards[i].first << " " << cards[n - i - 1].first << endl;
    }

    return 0;
}

