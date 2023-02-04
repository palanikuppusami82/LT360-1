package com.ladera.custom.exception;

@SuppressWarnings("serial")
public class SoltAlreadyBookedException  extends Exception{

	public SoltAlreadyBookedException(final String s)
    {
        super(s);
    }
}
