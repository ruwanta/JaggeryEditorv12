

/**
 @param {String|Object} Message
 @return void
 */
print = function (Message) {
};

/**
 @param {String} Log_Name

 */
Log = function (Log_Name) {
};


/**
 @param {String} debugMessage
 @return void
 */
Log.prototype.debug = function (debugMessage) {
};
/**
 @param {String} infoMessage
 @return void
 */
Log.prototype.info = function (infoMessage) {
};
/**
 @param {String} infoMessage
 @return void
 */
Log.prototype.warn = function (infoMessage) {
};
/**
 @param {String} errorMessage
 @return void
 */
Log.prototype.error = function (errorMessage) {
};
/**
 @param {String} fatalMessage
 @return void
 */
Log.prototype.fatal = function (fatalMessage) {
};
/**
 @type Boolean
 */
Log.prototype.isDebugEnabeld = function () {
};
/**
 @type Boolean
 */
Log.prototype.isTraceEnabled = function () {
};


/**
 @param {String} parameter
 @return TestNamespace
 */
require = function(parameter) {};

/**
 @constructor
 */
TestNamespace = new function(){


    /**
     @constructor
     @param {String}  smtp
     @param {String} [number]
     @param {String} username
     @param {String} password
     */
    TestNamespace.Sender = function(smtp,number,username,password){

        /**
         @type String
         */
        TestNamespace.Sender.prototype.from = 0 ;
        /**
         @type Array|String
         */
        TestNamespace.Sender.prototype.to = 0 ;
        /**
         @type Array|String
         */
        TestNamespace.Sender.prototype.cc = 0 ;
        /**
         @type Array|String
         */
        TestNamespace.Sender.prototype.bcc = 0 ;
        /**
         @type String
         */
        TestNamespace.Sender.prototype.subject = 0 ;
        /**
         @type String
         */
        TestNamespace.Sender.prototype.text = 0 ;
        /**
         @type XML|String
         */
        TestNamespace.Sender.prototype.html = 0 ;

        /**
         @param {String} [file]
         @param {File} [fileObject]
         @return void
         */
        TestNamespace.Sender.prototype.addAttachment = function (fileObject,file) {
        };
        /**
         @override
         @return void
         */
        TestNamespace.Sender.prototype.send = function () {
        };


    }


    /**
     @constructor
     */
    TestNamespace.WsRequest = function(){



        /**
         @type EventListener
         */
        TestNamespace.WSRequest.prototype.EventListener = 0 ;
        /**
         @type Number
         */
        TestNamespace.WSRequest.prototype.readyState = 0 ;
        /**
         @type Document
         */
        TestNamespace.WSRequest.prototype.responseXML = 0 ;
        /**
         @type XML
         */
        TestNamespace.WSRequest.prototype.responseE4X = 0 ;
        /**
         @type String
         */
        TestNamespace.WSRequest.prototype.responseText = 0 ;
        /**
         @type WebServiceError
         */
        TestNamespace.WSRequest.prototype.error = 0 ;

        /**
         @param {String} [httpMethod]
         @param {Object} [option]
         @param {String} url
         @param {String} [async]
         @param {String} [username]
         @param {String} [password]
         @return void
         */
        TestNamespace.WSRequest.prototype.open = function (httpMethod,option,url,async,username,password) {
        };

        /**
         @param {XML} payload
         @return void
         */
        TestNamespace.WSRequest.prototype.send = function (payload) {
        };

        /**
         @param {String} wsdlURL
         @param {Boolean} async
         @param {Array} options
         @return void
         */
        TestNamespace.WSRequest.prototype.openWSDL = function (wsdlURL,async,options) {
        };

        /**
         @param {String} operationName
         @param {XML|String} payload
         @param {Array} options
         @return void
         */
        TestNamespace.WSRequest.prototype.send = function (operationName,payload) {
        };


    }
    /**
     @constructor
     @param {String} wsdl
     */
    TestNamespace.WsStub = function(wsdl){


        /**
         @type Array
         */
        TestNamespace.WSStub.prototype.services = 0;
        /**
         @type Array
         */
        TestNamespace.WSStub.prototype.operations = 0;

        /**
         @return String
         */
        TestNamespace.WSStub.prototype.request = function () {
        };




    }
    /**
     @constructor
     @param {Object} provider
     */
    TestNamespace.OAuthProvider = function(provider){


        /**
         @return String
         */
        TestNamespace.OAuthProvider.prototype.getAuthorizationUrl = function() {};


        /**
         @param {String} authCode
         @return Object
         */
        TestNamespace.OAuthProvider.prototype.getAccessToken = function(authCode) {};

        /**
         @param {Object} accessToken
         @param {String} verb
         @param {String} url
         @return RespObj
         */
        TestNamespace.OAuthProvider.prototype.sendOAuthRequest = function(accessToken,verb,url) {};

    }


    /**
     * @function
     * @param {request} request
     * @return i18n
     */
    this.init = function(request){

    }

}


/**
 *
 @param {Object} provider
 @constructor
 */
i18n = function(provider) {};

/**
 @type String
 */
i18n.prototype.localeResourcesBasePath = 0 ;

/**
 @param {String} key
 @param {File} fallback
 @return void
 */
i18n.prototype.localize = function (key,fallback) {
};







WebServiceError = function() {};







/**
 *
 * @constructor
 */
RespObj = function() {};
/**
 @return String
 */
RespObj.prototype.getBody = function() {};



var request = {};
/**
 @return Boolean
 */
request.isSecure = function () {
};
/**
 @return String
 */
request.getMethod = function () {
};
/**
 @return String
 */
request.getProtocol = function () {
};
/**
 @return String
 */
request.getQueryString = function () {
};
/**
 @return {Object|String}
 */
request.getContent = function () {
};
request.getContentType = function () {
};
/**
 @return Number
 */
request.getContentLength = function () {
};
request.getRequestURI = function () {
};
request.getRequestURL = function () {
};
request.getPathInfo = function () {
};
request.getContextPath = function () {
};
/**
 @return Number
 */
request.getLocalPort = function () {
};
/**
 @param {String} headerName
 @return String
 */
request.getHeader = function (headerName) {
};
/**
 @param {String} paramName
 @return String
 */
request.getParameter = function (paramName) {
};
/**
 @param {String} formFeildName
 @return File
 */
request.getFile = function (formFeildName) {
};


var response = {};
/**
 @type String
 */
response.status = {};
/**
 @type String
 */
response.contentType = {};
/**
 @type {String | Object | XML}
 */
response.content = {};
/**
 @param {String} key
 @param {String} value
 @return String
 */
response.addHeader = function (key, value) {
};
/**
 @param {String} url
 @return void
 */
response.sendRedirect = function (url) {
};
/**
 @param {String} errCode
 @return void
 */
response.sendError = function (errCode) {
};


var session = {};
/**
 @type Number
 */
session.maxInactive = {};
/**
 @return String
 */
session.getCreationTime = function () {
};
/**
 @return String
 */
session.getLastAccessedTime = function () {
};
/**
 @param {String} key
 @param {String} value
 @return void
 */
session.put = function (key, value) {
};
/**
 @param {String} key
 @return String
 */
session.get = function (key) {
};
/**
 @return String
 */
session.getId = function () {
};
/**
 @param {String} key
 @return void
 */
session.remove = function (key) {
};
/**
 @return Boolean
 */
session.invalidate = function () {
};
/**
 @return Boolean
 */
session.isNew = function () {
};


var application = {};

/**
 @param {String} propertyName
 @return Object
 */
application.get = function (propertyName) {
};
/**
 @param {String} propertyName
 @param {Object} propertyName
 @return void
 */
application.put = function (propertyName, value) {
};
/**
 @param {String} propertyName
 @return void
 */
application.remove = function (propertyName) {
};



/**
 @param {String} url
 @param {Object} data
 @param {String} type
 @param {String} headers
 @param {Function} success
 @return Object
 */
get = function (url, data, type, headers, success) {
};
/**
 @param {String} url
 @param {Object} data
 @param {String} type
 @param {String} headers
 @param {Function} success
 @return Object
 */
post = function (url, data, type, headers, success) {
};
/**
 @param {String} url
 @param {Object} data
 @param {String} type
 @param {String} headers
 @param {Function} success
 @return Object
 */
put = function (url, data, type, headers, success) {
};
/**
 @param {String} url
 @param {Object} data
 @param {String} type
 @param {String} headers
 @param {Function} success
 @return Object
 */
del = function (url, data, type, headers, success) {
};


XMLHTTPRequest = function () {
};

/**
 @type String
 */
XMLHTTPRequest.prototype.status = 0;
/**
 @type String
 */
XMLHTTPRequest.prototype.readyState = 0;
/**
 @type String
 */
XMLHTTPRequest.prototype.statusText = 0;
/**
 @type String
 */
XMLHTTPRequest.prototype.responseText = 0;
/**
 @type XML
 */
XMLHTTPRequest.prototype.responseXML = 0;
/**
 @param {String} method
 @param {String} url
 @param {Boolean} [async]
 @return String
 */
XMLHTTPRequest.prototype.open = function (method, url, async) {
};
/**
 @param {String} string
 @return String
 */
XMLHTTPRequest.prototype.send = function (string) {
};
/**
 @return String
 */
XMLHTTPRequest.prototype.getAllResponseHeaders = function () {
};
/**
 @param {String} name
 @param {String} value
 @return void
 */
XMLHTTPRequest.prototype.setRequestHeader = function (name,value) {
};
/**
 @param {String} name
 @return String
 */
XMLHTTPRequest.prototype.getResponseHeader = function (name) {
};
/**
 @return void
 */
XMLHTTPRequest.prototype.abort = function () {
};

/**
 @param {String} uri
 */
URIMatcher = function (uri) {
};

/**
 @param {String} pattern
 @return Boolean
 */
URIMatcher.prototype.match = function (pattern) {
} ;
/**
 @return Object
 */
URIMatcher.prototype.elements = function () {
};

/**
 @param {String} path
 @return void
 */
include = function (path) {
};
/**
 @param {String} path
 @return String
 */
include_once = function (path) {
};

/**
 @param {String} uri
 */
Feed = function (uri) {
};
/**
 @type Array
 */
Feed.prototype.entries = 0;
/**
 @type Array
 */
Feed.prototype.authors = 0;
/**
 @type Array
 */
Feed.prototype.categories = 0;
/**
 @type Array
 */
Feed.prototype.contributors  = 0;
/**
 @type String
 */
Feed.prototype.logo = 0;
/**
 @type String
 */
Feed.prototype.icon = 0;
/**
 @type Array
 */
Feed.prototype.links = 0;
/**
 @type String
 */
Feed.prototype.title = 0;
/**
 @type Date
 */
Feed.prototype.updated = 0;
/**
 @return XML
 */
Feed.prototype.toXML = function () {
};

/**
 @return String
 */
Feed.prototype.toString = function () {
};


Entry = function () {
};
/**
 @type String
 */
Entry.prototype.id = 0;
/**
 @type Array
 */
Entry.prototype.authors = 0;
/**
 @type Array
 */
Entry.prototype.categories = 0;
/**
 @type String
 */
Entry.prototype.content = 0;
/**
 @type Array
 */
Entry.prototype.contributors = 0;
/**
 @type Array
 */
Entry.prototype.links = 0;
/**
 @type Date
 */
Entry.prototype.published = 0;
/**
 @type String
 */
Entry.prototype.rights = 0;
/**
 @type String
 */
Entry.prototype.summary = 0;
/**
 @type String
 */
Entry.prototype.title = 0;
/**
 @type Date
 */
Entry.prototype.updated = 0;






/**
 @param {String} filename
 */
File = function (filename) {
};
/**
 @param {String} mode
 @return void
 */
File.prototype.open = function (mode) {
};
/**
 @param {Object} object
 @return void
 */
File.prototype.write = function (object) {
}/**
 @param {Number} numberOfCharacters
 @return String
 */
File.prototype.read = function () {
};/**
 @return String
 */
File.prototype.getStream = function () {
};/**
 @return String
 */
File.prototype.readAll = function () {
}/**
 @return void
 */
File.prototype.close = function () {
};
/**
 @param {String} targetFileName
 @return Boolean
 */
File.prototype.move = function (targetFileName) {
};/**
 @param {String} targetLocation
 @return Boolean
 */
File.prototype.saveAs = function (targetLocation) {
}/**
 @return Boolean
 */
File.prototype.del = function () {
};/**
 @return Number
 */
File.prototype.getLength = function () {
};/**
 @return String
 */
File.prototype.getLastModified = function () {
};
/**
 @return String
 */
File.prototype.getName = function () {
};
/**
 @return Boolean
 */
File.prototype.isExists = function () {
} ;

/**
 @param {String} connectionUrl
 @param {String} username
 @param {String} password
 @param {Object} [config]
 */
Database = function (connectionUrl,username,password,config) {
};

/**
 @param {String} query
 @param {Function} callback
 @return String
 */
Database.prototype.close = function (query, callback) {
};

/**
 @return void
 */
Database.prototype.commit = function () {
};
/**
 @return void
 */
Database.prototype.rollback = function () {
} ;
/**
 @return void
 */
Database.prototype.close = function () {
} ;


/**
 @param {String} username
 @param {String} password

 */
MetadataStore = function (username,password) {
};

/**
 @param {String} path
 @return Boolean
 */
MetadataStore.prototype.resourceExists = function (path) {
};
/**
 @param {String} path
 @param {Object} start_pageSize
 @return Object
 */
MetadataStore.prototype.get = function (path,start_pageSize) {
};
/**
 @param {String} path
 @return void
 */
MetadataStore.prototype.remove = function (path) {
} ;
/**
 @param {String} suggestedPath
 @param {Resource} resourceOrCollection
 @return void
 */
MetadataStore.prototype.put = function (suggestedPath, resourceOrCollection) {
};
/**
 @return Resource
 */
MetadataStore.prototype.newResource = function () {
} ;
/**
 @return Collection
 */
MetadataStore.prototype.close = function () {
} ;


Resource = function () {
};
Collection = function () {
};


/**
 @param {String} jsonString
 @return Object
 */
parse = function(jsonString){};

/**
 @param {Object} jsonString
 @return String
 */

stringify = function(jsonString){};



var websocket = {}

/**
 * @type function
 */

websocket.onBinaryMessage;

/**
 * @type function
 */
websocket.onTextMessage;






