package java112.project3;

import java.util.*;

/**
 * This is a JavaBean that holds HTTP request data.
 */
public class HttpRequestData {

    private String remoteName;
    private String remoteAddress;
    private String httpMethod;
    private String requestURI;
    private StringBuffer requestURL;
    private String requestProtocol;
    private String serverName;
    private int serverPort;
    private Locale locale;
    private String queryString;
    private String queryParameter;
    private String requestUserHeader;

    public HttpRequestData() {
    }

    public String getRemoteName() {
        return remoteName;
    }

    public void setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public StringBuffer getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(StringBuffer requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestProtocol() {
        return requestProtocol;
    }

    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getQueryParameter() {
        return queryParameter;
    }

    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    public String getRequestUserHeader() {
        return requestUserHeader;
    }

    public void setRequestUserHeader(String requestUserHeader) {
        this.requestUserHeader = requestUserHeader;
    }
}