#include <iostream>
#include <vector>
#include <string>

const std::vector <std::string> numpad = {" ","", "abc", "def", "ghi", 
                                        "jkl", "mno", "pqrs", "tuv", 
                                        "wxyz"};

static const void display(std::vector <std::string> v) {
    for(std::vector <std::string>::iterator itr = v.begin(); itr != v.end(); ++itr)
        std::cout << *itr << " ";
    printf("\n");
}

static const void doLetterCombinations(std::string digits, 
                                        std::string aux,
                                        std::vector <std::string>& combinations, 
                                        int index = 0) {
    if (index == digits.length()) {
        combinations.emplace_back(aux);
        return;
    }

    int digit = digits[index] - '0';

    int size = numpad[digit].length();

    for(int i = 0; i < size; i++)
        doLetterCombinations(digits, aux + numpad[digit][i], combinations, index + 1);
}

static const std::vector <std::string> letterCombinations(std::string digits) {
    if (digits.empty())
        return combinations;
    std::vector <std::string> combinations;
    doLetterCombinations(digits, "", combinations);
    return combinations;
}

int main(int argc, char** argv) {
    std::string digits = "2";
    display(letterCombinations(digits));
    return 0;
}