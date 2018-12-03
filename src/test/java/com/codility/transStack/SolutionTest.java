package com.codility.transStack;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testExmple1() {
        Solution<Integer> sol = new Solution();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        assert sol.rollback() == true;  // rollback transaction 2
        assert sol.top() == 7;          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        assert sol.commit() == true;    // transaction 3 is committed
        assert sol.top() == 10;
        assert sol.rollback() == true;  // rollback transaction 1
        assert sol.top() == 4;          // stack: [4]
        assert sol.commit() == false;   // there is no open transaction

    }


    public void testExmple2() {
        Solution<Integer> sol = new Solution();
        sol.push(4);
        sol.begin();                    // start transaction 1
        sol.push(7);                    // stack: [4,7]
        sol.begin();                    // start transaction 2
        sol.push(2);                    // stack: [4,7,2]
        assert sol.rollback() == true;  // rollback transaction 2
        assert sol.top() == 7;          // stack: [4,7]
        sol.begin();                    // start transaction 3
        sol.push(10);                   // stack: [4,7,10]
        assert sol.commit() == true;    // transaction 3 is committed
        assert sol.top() == 10;
        assert sol.rollback() == true;  // rollback transaction 1
        assert sol.top() == 4;          // stack: [4]
        assert sol.commit() == false;   // there is no open transaction

    }
}
