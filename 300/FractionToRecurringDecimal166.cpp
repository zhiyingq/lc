class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        string result {}; // initialize the result
        // get the sign and put the sign to the result
        // tricky case: numerator = -Integer.MIN_VALUE, denominator = -1 => overflow
        // ^: same: 0, different: 1
        if (numerator == 0) { return "0"; }
        string sign = (numerator < 0 ^ denominator < 0) ? "-" : "";
        result.append(sign);
        
        // change the variables to long and get the absolute value to deal with the potential overflow
        long longNum = abs((long) numerator);
        long longDen = abs((long) denominator);
        // get the decimal number and put the decimal to the result
        string decimal = to_string(longNum / longDen);
        result.append(decimal);
        
        // deduct the decimal and deal with the fractional number
        // if the % is 0, we don't have any fractional number
        longNum %= longDen;
        if (longNum == 0) {
            return result;
        }
        
        // to deal with the fractional number
        result.push_back('.');
        unordered_map<long, size_t> map;
        
        while (longNum != 0) {
            unordered_map<long, size_t>::const_iterator got = map.find(longNum);
            // if find the got, which means that we have met the exactly same number
            if (got != map.end()) {
                result.insert(got->second, "(");
                result.append(")");
                break;
            }
            else {
                map.insert(pair<long, size_t>{longNum, result.size()});     
            }
            
            longNum *= 10;
            decimal = to_string(longNum / longDen);
            longNum %= longDen;
            result.append(decimal);
            
            
        }
        return result;
    }
};