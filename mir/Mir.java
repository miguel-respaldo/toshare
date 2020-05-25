/*
 * Copyright (C) <year> <name of author>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */

public class Mir {
    private String next;
    private int index;

    public Mir(String _next) {
        next = _next;
        index = 0;
    }

    private boolean term(char token) {
        if ( index != next.length() )
            return next.charAt(index++) == token;
        else
            return false;
    }

    private boolean S() {
        return term('c') && A() && term('d');
    }

    private boolean A() {
        int save = index;
        //return A1() || (index = save, A2());
        if ( ! A1() ) {
            index=save;
            return A2();
        }
        return true;
    }

    private boolean A1() {
        return term('a') && term('b');
    }

    private boolean A2() {
        return term('a');
    }

    public boolean test() {
        return S() && index == next.length();
    }

    public static void main(String args[]) {
        Mir m = new Mir("caed");

        if ( m.test() ) {
            System.out.println("aceptada");
        } else {
            System.out.println("no aceptada");
        }
    }
}

/*
 * Editor modelines  -  https://www.wireshark.org/tools/modelines.html
 *
 * Local variables:
 * c-basic-offset: 4
 * tab-width: 4
 * indent-tabs-mode: nil
 * End:
 *
 * vi: set shiftwidth=4 tabstop=4 expandtab:
 * :indentSize=4:tabSize=4:noTabs=true:
 */

