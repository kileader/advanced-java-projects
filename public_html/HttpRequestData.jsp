<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="index-head.jsp"%>
<body>
<div id="container">
    <%@ include file="index-header.jsp"%>
    <div id="main_content_top"></div>
    <div id="main_content">
        <div class="content">
            <h2>HTTP Request Data</h2>
            <ul>
                <li>
                    Remote computer making the request:
                    ${requestData.getRemoteName()}
                </li>
                <li>
                    Address of remote computer making the request:
                    ${requestData.getRemoteAddress()}
                </li>
                <li>
                    HTTP method of the request:
                    ${requestData.getHttpMethod()}
                </li>
                <li>
                    Request URI:
                    ${requestData.getRequestURI()}
                </li>
                <li>
                    Request URL:
                    ${requestData.getRequestURL()}
                </li>
                <li>
                    Protocol of the request:
                    ${requestData.getRequestProtocol()}
                </li>
                <li>
                    Server name:
                    ${requestData.getServerName()}
                </li>
                <li>
                    Server port number:
                    ${requestData.getServerPort()}
                </li>
                <li>
                    Current locale of the server:
                    ${requestData.getLocale()}
                </li>
                <li>
                    Query string:
                    ${requestData.getQueryString()}
                </li>
                <li>
                    Query parameter:
                    ${requestData.getQueryParameter()}
                </li>
                <li>
                    User-Agent header:
                    ${requestData.getRequestUserHeader()}
                </li>
            </ul>
            <a href="/java112">Home</a>
        </div>
        <%@ include file="index-menu.jsp"%>
        <div id="clear"></div>
    </div>
    <div id="main_content_bottom"></div>
    <%@ include file="index-footer.jsp"%>
</div>
</body>
</html>
