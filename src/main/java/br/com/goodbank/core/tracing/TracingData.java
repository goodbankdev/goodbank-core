package br.com.goodbank.core.tracing;

public record TracingData(String correlationId, String tracingId, String requestId, String appId, String callerAppId) {
}
