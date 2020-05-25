/*
 * Copyright (C) <year> <name of author>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

#include <iostream>

char const *next;    

bool S(); 
bool A(); 
bool A1(); 
bool A2();

bool term(char token) {
    if (*next != '\0')
        return *next++ == token;
    else
        return false;
}

bool S() {
    return term('c') && A() && term('d');
}   

    
bool A() {
    char const *save = next;
    return A1() || (next = save, A2());
}

bool A1() {
    return term('a') && term('b');
}
bool A2() {
    return term('a') ;
}

int main() {
    next = "caed";
    
    if (S() && *next == '\0') {
        std::cout << "aceptada";
    }
    else
        std::cout << "no aceptada";
}


/*
 * Editor modelines  -  https://www.wireshark.org/tools/modelines.html
 *
 * Local variables:
 * c-basic-offset: 8
 * tab-width: 8
 * indent-tabs-mode: t
 * End:
 *
 * vi: set shiftwidth=8 tabstop=8 noexpandtab:
 * :indentSize=8:tabSize=8:noTabs=false:
 */

