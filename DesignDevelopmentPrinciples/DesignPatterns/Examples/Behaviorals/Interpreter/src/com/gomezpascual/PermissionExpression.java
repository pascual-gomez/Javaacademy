package com.gomezpascual;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
