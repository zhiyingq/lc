#include <iostream>
#include <unordered_map>
using namespace std;

class Solution {
public:
	//1
	bool isIsomorphic(string s, string t) {
        if (s.size() != t.size()) return false;
        int m1[256] {};
        int m2[256] {};
        // fill_n(arrs, 256, -1);
        // fill_n(arrt, 256, -1);
        
        for (int i = 0; i < s.size(); i++) {
            if (m1[s[i]] != m2[t[i]]) return false;
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        
        return true;
    }

    //2
    bool isIsomorphic(string s, string t) {
        // if s.length() ！= t.length() return false;
        if (s.size() != t.size()) return false;
        // create a map to map the relatinoship
        unordered_map<char, char> map;
        set<char> set;
        for (size_t i = 0; i < s.size(); i++) {
            // cout << "This is the " << i << "th index" << endl;
        	unordered_map<char, char>::const_iterator got = map.find(s[i]);
        	// if fint the goal, check whether t[i] = map[s[i]]
        	if (got != map.end()) {
                // cout << got->first << " -> " << got->second << "found";
                // cout << "t[i] = " << t[i] << ", s[i] = " << s[i] << endl;
        		if (t[i] != got->second) return false;
        	}
        	else {
                // cout << "map.insert(" << s[i] << ", " << t[i] << ")" << endl; 
                // check whether t[i] already exists
                if (set.find(t[i]) != set.end()) return false;
        		map.insert(pair<char, char> {s[i], t[i]});
                set.insert(t[i]);
                      
        	}
        }
        return true;
    }
};

int main() {
	cout << "Hello word" << endl;
}

