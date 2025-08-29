package br.com.WendellAndrade.exception;

import java.util.Date;

public record ExceptionResponse(Date timesTamp, String menssage, String datails) {}
