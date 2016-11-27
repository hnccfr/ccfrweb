/*
 * artDialog 4.0.2
 * Date: 2011-07-12 10:49
 * http://code.google.com/p/artdialog/
 * (c) 2009-2010 TangBin, http://www.planeArt.cn
 *
 * This is licensed under the GNU LGPL, version 2.1 or later.
 * For details, see: http://creativecommons.org/licenses/LGPL/2.1/
 */
 
 
/*!
	"art"�ײ����΢�Ϳ⣬ģ�� jQuery DOM �����ӿڣ�ѹ����8KB���ҡ�
------------------------------------------------------------------*/
;(function (window, undefined) {
if (window.jQuery) return jQuery;

var $ = window.art = function (selector, content) {
    	return new $.fn.init(selector, content);
	},
    readyBound = false,
    readyList = [],
	timers = [],
    DOMContentLoaded, timerId, 
	isOpacity = 'opacity' in document.documentElement.style,
	hasOwnProperty = Object.prototype.hasOwnProperty,
	quickExpr = /^(?:[^<]*(<[\w\W]+>)[^>]*$|#([\w\-]+)$)/,
	rroot = /^(?:body|html)$/i,
	rbox = /^(?:div|span)$/i,
	rclass = /[\n\t]/g,
	ralpha = /alpha\([^)]*\)/i,
	ropacity = /opacity=([^)]*)/,
    rfxnum = /^([+-]=)?([\d+-.]+)(.*)$/;

if (window.$ === undefined) window.$ = $;
$.fn = $.prototype = {
	constructor: $,
	
    /**
	 * DOM ����
	 * @param	{Function}	�ص�����
	 * @return	{this}
	 */
    ready: function (callback) {
        $.bindReady();

        if ($.isReady) {
            callback.call(document, $);
        } else if (readyList) {
            readyList.push(callback);
        };

        return this;
    },

    /**
	 * �ж���ʽ���Ƿ����
	 * @param	{String}	����
	 * @return	{Boolean}
	 */
    hasClass: function (name) {		
		var className = ' ' + name + ' ';
		if ((' ' + this[0].className + ' ').replace(rclass, ' ').indexOf(className) > -1) return true;

		return false;
    },

    /**
	 * �����ʽ��
	 * @param	{String}	����
	 * @return	{this}
	 */
    addClass: function (name) {
        if (!this.hasClass(name)) this[0].className += ' ' + name;

        return this;
    },

    /**
	 * �Ƴ���ʽ��
	 * @param	{String}	����
	 * @return	{this}
	 */
    removeClass: function (name) {
        var elem = this[0];

        if (!name) {
            elem.className = '';
        } else
		if (this.hasClass(name)) {
            elem.className = elem.className.replace(name, ' ');
        };

        return this;
    },

    /**
	 * ��д��ʽ<br />
     * css(name) ���ʵ�һ��ƥ��Ԫ�ص���ʽ����<br />
     * css(properties) ��һ��"��/ֵ��"��������Ϊ����ƥ��Ԫ�ص���ʽ����<br />
     * css(name, value) ������ƥ���Ԫ���У�����һ����ʽ���Ե�ֵ<br />
	 * @return	{this}
	 */
    css: function (name, value) {
        var i, elem = this[0], obj = arguments[0];

        if (typeof name === 'string') {
            if (value === undefined) {
                return $.css(elem, name);
            } else {
                name === 'opacity' ?
					$.opacity.set(elem, value) :
					elem.style[name] = value;
            };
        } else {
            for (i in obj) {
				i === 'opacity' ?
					$.opacity.set(elem, obj[i]) :
					elem.style[i] = obj[i];
			};
        };

        return this;
    },

    /**
	 * ��ȡ����ĵ�������
	 * @return	{Object}	����left��top����ֵ
	 */
    offset: function () {
        var elem = this[0],
            box = elem.getBoundingClientRect(),
            doc = elem.ownerDocument,
            body = doc.body,
            docElem = doc.documentElement,
            clientTop = docElem.clientTop || body.clientTop || 0,
            clientLeft = docElem.clientLeft || body.clientLeft || 0,
            top = box.top + (self.pageYOffset || docElem.scrollTop) - clientTop,
            left = box.left + (self.pageXOffset || docElem.scrollLeft) - clientLeft;

        return {
            left: left,
            top: top
        };
    },
	
    /**
	 * �ⷵ�ظ�Ԫ���е�һ����position��Ϊrelative����absolute��Ԫ��
	 * @return	{HTMLElement}
	 */
	/* offsetParent: function () {
		var offsetParent = this[0].offsetParent || document.body;

		while (offsetParent && (!rroot.test(offsetParent.nodeName) && $.css(offsetParent, 'position') === 'static')) {
			offsetParent = offsetParent.offsetParent;
		};
		
		return $(offsetParent);
	}, */
	
    /**
	 * ��ȡƥ��Ԫ����Ը�Ԫ�ص�ƫ��
	 * @return	{Object}
	 */
	/* position: function() {
		var elem = this[0],
			offsetParent = this.offsetParent(),
			offset = this.offset(),
			parentOffset = rroot.test(offsetParent[0].nodeName) ? { top: 0, left: 0 } : offsetParent.offset();

		offset.top -= parseFloat($.css(elem, 'marginTop')) || 0;
		offset.left -= parseFloat($.css(elem, 'marginLeft')) || 0;

		parentOffset.top += parseFloat($.css(offsetParent[0], 'borderTopWidth')) || 0;
		parentOffset.left += parseFloat($.css(offsetParent[0], 'borderLeftWidth')) || 0;

		return {
			top: offset.top  - parentOffset.top,
			left: offset.left - parentOffset.left
		};
	}, */
	
    /**
	 * д�����ݻ���
	 * @param	{String}	����
	 * @param	{Object}	����
	 * @return	{Object}	����
	 */
	/* data: function (name, data) {
		var thisCache,
			hasCache = hasOwnProperty.call(this[0], $.expando);
	
		if (!hasCache) this[0][$.expando] = {};
		thisCache = this[0][$.expando];
		
		if (typeof name === 'string') {
			if (data !== undefined) thisCache[name] = data;
			return this;
		};
		
		return thisCache;
	}, */
	
    /**
	 * ɾ�����ݻ���
	 * @param	{String}	����
	 * @param	{Object}	����
	 */
	/* removeData: function (name) {
		if (name) {
			if (hasOwnProperty.call(this[0], $.expando)) {
				delete this[0][$.expando][name];
				if ((function (obj) {
					for (var name in obj) return false;
					return true;
				})(this[0][$.expando])) delete this[0][$.expando];
			};
		} else 
			delete this[0][$.expando];
	}, */
	
	/**
	 * ��дHTML - (��֧���ı���)
	 * @param	{String}	����
	 * @return	{this}
	 */
	html: function (content) {
		if (content === undefined) return this[0].innerHTML;
		this[0].innerHTML = content;
		
		return this;
	},
	
	/**
	 * ��ÿ��ƥ���Ԫ���ڲ�׷������
	 * @param	{String}	����
	 * @return	{this}
	 */
    /* append: function (content) {
        var elem = this[0];

        if (elem.insertAdjacentHTML) {
            elem.insertAdjacentHTML('beforeEnd', content);
        } else {
            var range = elem.ownerDocument.createRange(),
                frag;
            if (elem.lastChild) {
                range.setStartAfter(elem.lastChild);
                frag = range.createContextualFragment(content);
                elem.appendChild(frag);
            } else {
                elem.innerHTML = content;
            };
        };

        return this;
    }, */

	/**
	 * �Ƴ��ڵ�
	 */
    remove: function () {
        var elem = this[0], i;

        // ɾ���ӽڵ��ֹIE�ڴ�й©
		while (elem.firstChild) {
			
			// ɾ���¼���
			//$.event.remove(elem);
			 
			// ɾ�����ݻ���
			if (elem[$.expando]) delete elem[$.expando];
			// IE6��7 iframe ɾ������ܵ���input�޷������BUG
			if ('src' in elem) elem.src = 'about:blank';
			
			elem.removeChild(elem.firstChild);
			
		};

        elem.parentNode.removeChild(elem);
        elem = null;
		
		// IE˽�к����ͷ��ڴ�
        ('CollectGarbage' in window) && CollectGarbage();
    }
};

$.fn.init = function (selector, content) {
	var match, elem;
	content = content || document;
	
	if (!selector) return this;
	
	if (selector.nodeType) {
		this[0] = selector;
		return this;
	};
	
	if (selector === 'body' && content.body) {
		this[0] = content.body;
		return this;
	};
	
	if (selector === 'head' || selector === 'html') {
		this[0] = content.getElementsByTagName(selector)[0];
		return this;
	};
		
	if (typeof selector === 'string') {
		match = quickExpr.exec(selector);

		if (match && match[2]) {
			elem = content.getElementById(match[2]);
			if (elem && elem.parentNode) this[0] = elem;
			return this;
		};
	};
	
	if (typeof selector === 'function') return $(document).ready(selector);
	
	this[0] = selector;
	
	return this;
};
$.fn.init.prototype = $.fn;

$.expando = '{$' + (new Date).getTime() + '}';
$.noop = function () {};

/** ���window */
$.isWindow = function (obj) {
	return obj && typeof obj === 'object' && 'setInterval' in obj;
};

/** �����ж� */
$.isArray = function (obj) {
    return Object.prototype.toString.call(obj) === '[object Array]';
};

/**
 * ����������ָ��CSS��ƥ���Ԫ��. ע�⣺��������һ��Ԫ�أ���jQuery��ͬ
 * @param	{String}	��֧��.class��tag����ʽ
 * @return	{this}
 */
$.fn.find = function (expr) {
	var value, elem = this[0],
		className = expr.split('.')[1];

	if (className) {
		if (document.getElementsByClassName) {
			value = elem.getElementsByClassName(className);
		} else {
			value = getElementsByClassName(className, elem);
		};
	} else {
		value = elem.getElementsByTagName(expr);
	};
	
	return $(value[0]);
};
function getElementsByClassName (className, node, tag) {
	node = node || document;
	tag = tag || '*';
	var i = 0,
		j = 0,
		classElements = [],
		els = node.getElementsByTagName(tag),
		elsLen = els.length,
		pattern = new RegExp("(^|\\s)" + className + "(\\s|$)");
		
	for (; i < elsLen; i ++) {
		if (pattern.test(els[i].className)) {
			classElements[j] = els[i];
			j ++;
		};
	};
	return classElements;
};

/**
 * ����
 * @param {Object}
 * @param {Function}
 */
$.each = function (obj, callback) {
    var name, i = 0,
        length = obj.length,
        isObj = length === undefined;

    if (isObj) {
        for (name in obj) {
            if (callback.call(obj[name], name, obj[name]) === false) break;
        };
    } else {
        for (var value = obj[0]; i < length && callback.call(value, i, value) !== false; value = obj[++i]) {};
    };
	
	return obj;
};

/**
 * ��ajax֧��
 * @example
 * $.ajax({
 * 		url: url,
 * 		success: callback,
 * 		cache: cache
 * });
 */
$.ajax = function (config) {
	var ajax = window.XMLHttpRequest ?
			new XMLHttpRequest() :
			new ActiveXObject('Microsoft.XMLHTTP'),
		url = config.url;
	
	if (config.cache === false) {
		var ts = (new Date()).getTime(),
			ret = url.replace(/([?&])_=[^&]*/, "$1_=" + ts );
		url = ret + ((ret === url) ? (/\?/.test(url) ? "&" : "?") + "_=" + ts : "");
	};
	
	ajax.onreadystatechange = function() {
		if (ajax.readyState === 4 && ajax.status === 200) {
			config.success && config.success(ajax.responseText);
			ajax.onreadystatechange = $.noop;
		};
	};
	ajax.open('GET', url, 1);
	ajax.send(null);
};

/**
 * �¼���
 * @param	{String}	����
 * @param	{Function}	Ҫ�󶨵ĺ���
 * @return	{this}
 */
$.fn.bind = function (type, callback) {
	$.event.add(this[0], type, callback);
	return this;
};

/**
 * �Ƴ��¼�
 * @param	{String}	����
 * @param	{Function}	Ҫж�صĺ���
 * @return	{this}
 */
$.fn.unbind = function(type, callback) {
	$.event.remove(this[0], type, callback);
	return this;
};

/**
 * �����¼�
 * @param	{String}	����
 * @param	{Array}		(��ѡ)���ݸ��¼��������ĸ��Ӳ���
 * @return	{this}
 */
$.fn.triggerHandler = function (type, data) {
	$.event.triggerHandler(this[0], type, data);
	return this;
};


// �¼�����
$.event = (function () {

var _isDOM = document.addEventListener,
	_noop = function () {},
	_now = function () {return (new Date).getTime()},
	_returnFalse = function () {return false},
	_returnTrue = function () {return true};
	
var _Event = function ( src ) {
	this.originalEvent = src;
	this.type = src.type;
	this.timeStamp = _now();
};
_Event.prototype = {
	preventDefault: function () {
		this.isDefaultPrevented = _returnTrue;
		var e = this.originalEvent;
		if( e.preventDefault ) {
			e.preventDefault();
		}
		e.returnValue = false;
	},
	stopPropagation: function () {
		this.isPropagationStopped = _returnTrue;
		var e = this.originalEvent;
		if( e.stopPropagation ) {
			e.stopPropagation();
		}		
		e.cancelBubble = true;
	},
	stopImmediatePropagation: function () {
		this.isImmediatePropagationStopped = _returnTrue;
		this.stopPropagation();
	},
	isDefaultPrevented: _returnFalse,
	isPropagationStopped: _returnFalse,
	isImmediatePropagationStopped: _returnFalse
};

return {
	
	// ����¼�
	add: function (elem, type, callback) {
		elem._listeners = elem._listeners || {};
		
		var eventHandle,
			that = this,
			special = that.special[type] || {},
			handler = '${handler}',
			_listeners = elem._listeners[type] = elem._listeners[type] || [];
			
		_listeners.push(callback);
		
		if (!_listeners[handler]) {
			eventHandle = _listeners[handler] = function (event){
				var data = event['${data}'] || [];
				event = that.fix(event || window.event, elem);
				data.unshift(event);
				for (var i = 0, fn; fn = _listeners[i++];) {
					if (fn.apply(elem, data) === false) {
						event.preventDefault();
						event.stopPropagation();
					};
				};
			};
			
			if (!special.setup || special.setup.call(elem, eventHandle) === false) {
				that.on(elem, type, eventHandle);
			};
		};
	},
	
	// ɾ���¼�
	remove: function (elem, type, callback) {
		if (!elem._listeners) return;
		
		var empty = true,
			special = this.special[type] || {},
			_listeners = elem._listeners && elem._listeners[type];
			
		if (_listeners) {			
			for (var i = 0; i < _listeners.length; i ++) {
				_listeners[i] === callback && _listeners.splice(i--, 1);
			};
			
			if (_listeners.length === 0 && (!special.teardown || special.teardown.call(elem) === false)) {
				this.un(elem, type, _listeners['${handler}']);
				delete elem._listeners[type];
				for (var n in elem._listeners) empty = false;
				if (empty) elem._listeners = null;// delete elem._listeners;
			};
		};
	},
	
	special: {},
	
	// ԭ���¼��󶨽ӿ�
	on: _isDOM ? function (elem, type, callback) {
		elem.addEventListener(type, callback, false);
	} : function (elem, type, callback) {
		elem.attachEvent('on' + type, callback);
	},
	
	// ԭ���¼�ж�ؽӿ�
	un: _isDOM ? function (elem, type, callback) {
		elem.removeEventListener(type, callback, false);
	} : function (elem, type, callback) {
		elem.detachEvent('on' + type, callback);
	},
	
	// �ϴ���ĳ���¼� - (��֧���Զ����¼�)
	trigger: function (elem, type, data) {
		try {
			if (elem.dispatchEvent){
				var event = document.createEvent('Event');
				event.initEvent(type, true, true);
				event['${data}'] = data;
				elem.dispatchEvent(event);
			} else if (elem.fireEvent) {
				var event = document.createEventObject();
				event['${data}'] = data;
				elem.fireEvent('on' + type, event);
			};
		} catch (e) {};
	},
	
	// ����ĳ���¼� (��ð��Ҳ������Ĭ����Ϊ��֧���Զ����¼�)
	triggerHandler: function (elem, type, data/*, evt*/) {
		evt = arguments[3] || {};
		var cache = elem._listeners && elem._listeners[type],
			handler = cache && cache['${handler}'],
			event = {
				type: type,
				target: elem,
				currentTarget: elem,
				preventDefault: _noop,
				stopPropagation: _noop,
				'${data}': data
			};
			
		for (var i in evt) event[i] = evt[i];
		handler && handler.call(elem, event);
		
		try {
			elem['on' + type] && elem['on' + type].apply(elem, data);
		} catch (e) {};
	},
	
	props: "altKey attrChange attrName bubbles button cancelable charCode clientX clientY ctrlKey currentTarget data detail eventPhase fromElement handler keyCode layerX layerY metaKey newValue offsetX offsetY originalTarget pageX pageY prevValue relatedNode relatedTarget screenX screenY shiftKey srcElement target toElement view wheelDelta which".split(" "),
	
	// �¼���������
	fix: function (event, elem) {
		var props = this.props,
			len   = props.length;

		var originalEvent = event;
		event = new _Event( originalEvent );
		
		for(var i = len, prop; i;) {
			prop = props[ --i ];
			event[ prop ] = originalEvent[ prop ];
		}
		if(!event.target) {
			event.target = event.srcElement || document;
		}
		if( event.target.nodeType === 3 ) {
			event.target = event.target.parentNode;
		}
		if( !event.relatedTarget && event.fromElement ) {
			event.relatedTarget = event.fromElement === event.target ? event.toElement : event.fromElement;
		}
		if( event.pageX == null && event.clientX != null ) {
			var doc = document.documentElement, body = document.body;
			event.pageX = event.clientX + (doc && doc.scrollLeft || body && body.scrollLeft || 0) - (doc && doc.clientLeft || body && body.clientLeft || 0);
			event.pageY = event.clientY + (doc && doc.scrollTop  || body && body.scrollTop  || 0) - (doc && doc.clientTop  || body && body.clientTop  || 0);
		}
		if( !event.which && ((event.charCode || event.charCode === 0) ? event.charCode : event.keyCode) ) {
			event.which = event.charCode || event.keyCode;
		}
		if( !event.metaKey && event.ctrlKey ) {
			event.metaKey = event.ctrlKey;
		}
		if( !event.which && event.button !== undefined ) {
			event.which = (event.button & 1 ? 1 : ( event.button & 2 ? 3 : ( event.button & 4 ? 2 : 0 ) ));
		}		
		if(!event.currentTarget) event.currentTarget = elem;

		return event;
	}
};

}());

// DOM�����¼�
$.isReady = false;
$.ready = function () {
    if (!$.isReady) {
        if (!document.body) return setTimeout($.ready, 13);
        $.isReady = true;

        if (readyList) {
            var fn, i = 0;
            while ((fn = readyList[i++])) {
                fn.call(document, $);
            };
            readyList = null;
        };
    };
};
$.bindReady = function () {
    if (readyBound) return;

    readyBound = true;

    if (document.readyState === 'complete') {
        return $.ready();
    };

    if (document.addEventListener) {
        document.addEventListener('DOMContentLoaded', DOMContentLoaded, false);
        window.addEventListener('load', $.ready, false);
    } else if (document.attachEvent) {
        document.attachEvent('onreadystatechange', DOMContentLoaded);
        window.attachEvent('onload', $.ready);
        var toplevel = false;
        try {
            toplevel = window.frameElement == null;
        } catch (e) {};

        if (document.documentElement.doScroll && toplevel) {
            doScrollCheck();
        };
    };
};
$.event.special.ready = {
	setup: $.bindReady,
	teardown: $.noop
};
if (document.addEventListener) {
    DOMContentLoaded = function () {
        document.removeEventListener('DOMContentLoaded', DOMContentLoaded, false);
        $.ready();
    };
} else if (document.attachEvent) {
    DOMContentLoaded = function () {
        if (document.readyState === 'complete') {
            document.detachEvent('onreadystatechange', DOMContentLoaded);
            $.ready();
        };
    };
};

function doScrollCheck () {
    if ($.isReady) return;

    try {
        document.documentElement.doScroll('left');
    } catch (e) {
        setTimeout(doScrollCheck, 1);
        return;
    };
    $.ready();
};

// ��ȡcss
$.css = 'defaultView' in document && 'getComputedStyle' in document.defaultView ?
	function (elem, name) {
		return document.defaultView.getComputedStyle(elem, false)[name]
} :
	function (elem, name) {
		var ret = name === 'opacity' ? $.opacity.get(elem) :
			elem.currentStyle && elem.currentStyle[name];
		return ret || '';
};

// �����������opacity
$.opacity = {
	get: function (elem) {
		return isOpacity ?
			document.defaultView.getComputedStyle(elem, false).opacity :
			ropacity.test((elem.currentStyle ? elem.currentStyle.filter : elem.style.filter) || '') ?
				(parseFloat(RegExp.$1) / 100) + '' :
				1;
	},
	set: function (elem, value) {
		if (isOpacity) return elem.style.opacity = value;
		var style = elem.style;
		style.zoom = 1;

		var opacity = 'alpha(opacity=' + value * 100 + ')',
			filter = style.filter || '';

		style.filter = ralpha.test(filter) ?
			filter.replace(ralpha, opacity) :
			style.filter + ' ' + opacity;
	}
};

/**
 * ��������ȡ
 * ��ȡ�ĵ���ֱ��������$(document).scrollTop()
 * @param	{Number}	�������������ı������λ�ã�����Ϊ��ȡλ��
 * @return	{Number}	���ع�����λ��
 */
$.each(['Left', 'Top'], function (i, name) {
    var method = 'scroll' + name;

    $.fn[method] = function (val) {
        var elem = this[0],
            win;

        if (!elem) {
            return null;
        };

        if (val !== undefined) {
            win = getWindow(this);

            if (win) {
                win.scrollTo(!i ? val : $(win).scrollLeft(), i ? val : $(win).scrollTop());
            } else {
                this[method] = val;
            };
            return this;
        } else {
            win = getWindow(elem);
            return win ?
				('pageXOffset' in win) ?
					win[i ? 'pageYOffset' : 'pageXOffset'] :
					win.document.documentElement[method] || win.document.body[method] :
				elem[method];
        };
    };
});

function getWindow (elem) {
	return $.isWindow(elem) ?
		elem :
		elem.nodeType === 9 ?
			elem.defaultView || elem.parentWindow :
			false;
};

/**
 * Ԫ�سߴ��ȡ - [ֻ֧��window��document]
 * ��ȡ�ĵ���ȣ�$(document).width()
 * ��ȡ���ӷ�Χ��$(window).width()
 */
$.each(['Height', 'Width'], function (i, name) {
    var type = name.toLowerCase();

    $.fn[type] = function (size) {
        var elem = this[0];
        if (!elem) {
            return size == null ? null : this;
        };

		return $.isWindow(elem) ?
			elem.document.documentElement['client' + name] || elem.document.body['client' + name] :
			(elem.nodeType === 9) ?
				Math.max(
					elem.documentElement['client' + name],
					elem.body['scroll' + name], elem.documentElement['scroll' + name],
					elem.body['offset' + name], elem.documentElement['offset' + name]
				) :
				size === undefined ?
					parseFloat($.css(elem, type)) :
					this.css(type, typeof size === 'string' ? size : size + 'px');
    };

});

/** �Զ��嶯�� - ��֧����ʽ�жӲ��� */
$.fn.animate = function (prop, speed, easing, callback) {
	
	speed = speed || 400;
	if (typeof easing === 'function') callback = easing;
	easing = easing && $.easing[easing] ? easing : 'swing';
	
    var $this = this, overflow,
        fx, parts, start, end, unit,
		opt = {
			speed: speed,
			easing: easing,
			callback: function () {
				if (overflow != null) $this[0].style.overflow = '';
				callback && callback();
			}
		};
	
	opt.curAnim = {};
	$.each(prop, function (name, val) {
		opt.curAnim[name] = val;
	});
	
    $.each(prop, function (name, val) {
        fx = new $.fx($this[0], opt, name);
        parts = rfxnum.exec(val);
        start = parseFloat(name === 'opacity' || ($this[0].style && $this[0].style[name] != null) ?
			$.css($this[0], name) :
			$this[0][name]);
        end = parseFloat(parts[2]);
        unit = parts[3];
		if (name === 'height' || name === 'width') {
			end = Math.max(0, end);
			overflow = [$this[0].style.overflow, $this[0].style.overflowX, $this[0].style.overflowY];
		};
		
        fx.custom(start, end, unit);
    });
	
	if (overflow != null) $this[0].style.overflow = 'hidden';

    return this;
};

$.fx = function (elem, options, prop) {
    this.elem = elem;
    this.options = options;
    this.prop = prop;
};

$.fx.prototype = {
    custom: function (from, to, unit) {
        this.startTime = $.fx.now();
        this.start = from;
        this.end = to;
        this.unit = unit;
        this.now = this.start;
        this.state = this.pos = 0;

        var self = this;

        function t() {
            return self.step();
        };
        t.elem = this.elem;
		t();
        timers.push(t)
        if (!timerId) timerId = setInterval($.fx.tick, 13);
    },
    step: function () {
        var t = $.fx.now(), done = true;
        if (t >= this.options.speed + this.startTime) {
            this.now = this.end;
            this.state = this.pos = 1;
            this.update();
			
			this.options.curAnim[this.prop] = true;
			for (var i in this.options.curAnim) {
				if (this.options.curAnim[i] !== true) {
					done = false;
				};
			};
			
			if (done) this.options.callback.call(this.elem);
			
            return false;
        } else {
            var n = t - this.startTime;
            this.state = n / this.options.speed;
            this.pos = $.easing[this.options.easing](this.state, n, 0, 1, this.options.speed);
            this.now = this.start + ((this.end - this.start) * this.pos);
            this.update();
            return true;
        };
    },
    update: function () {
		if (this.prop === 'opacity') {
			$.opacity.set(this.elem, this.now);
		} else
		if (this.elem.style && this.elem.style[this.prop] != null) {
			this.elem.style[this.prop] = this.now + this.unit;
		} else {
			this.elem[this.prop] = this.now;
		};
    }
};

$.fx.now = function () {
    return new Date().getTime();
};

$.easing = {
    linear: function (p, n, firstNum, diff) {
        return firstNum + diff * p;
    },
    swing: function (p, n, firstNum, diff) {
        return ((-Math.cos(p * Math.PI) / 2) + 0.5) * diff + firstNum;
    }
};

$.fx.tick = function () {
    for (var i = 0; i < timers.length; i++) {
        !timers[i]() && timers.splice(i--, 1);
    };
    !timers.length && $.fx.stop();
};

$.fx.stop = function () {
    clearInterval(timerId);
    timerId = null;
};

$.fn.stop = function () {
    for (var i = timers.length - 1; i >= 0; i--)
    	timers[i].elem === this[0] && timers[i].stop();
    return this;
};

//-------------end
return $}(window));







/*!
	�Ի���������
	@name		$.dialog
	@param		{Object, String}	����, ��Ϣ����
	@param		{Function}			(��ѡ) ȷ�ϰ�ť�ص�����
	@param		{Function}			(��ѡ) ȡ����ť�ص�����
	@return		$.dialog.prototype
------------------------------------------------------------------*/
;(function ($, window, undefined) {
$.log = function (content) {window.console && console.log(content)};
$(function () {
	!window.jQuery && document.compatMode === 'BackCompat'
	&& alert('artDialog Error: document.compatMode === "BackCompat"');
});

var _oldApi, _thisScript, _skin, _path, _tmplEngine,
	_count = 0,
	_$window = $(window),
	_$document = $(document),
	_$html = $('html'),
	_$body = $(function(){_$body = $('body')}),
	_elem = document.documentElement,
	_isIE6 = !-[1,] && !('minWidth' in _elem.style),
	_isMobile = 'ontouchend' in _elem && !('onmousemove' in _elem)
		|| /(iPhone|iPad|iPod)/i.test(navigator.userAgent),
	_expando = '{$artDialog' + (new Date).getTime() + '}';

var artDialog = function (config, yesFn, noFn) {
	config = config || {};
	var follow, followApi, i,
		buttons = [],
		defaults = artDialog.defaults,
		repeat = artDialog.list[config.id];
	
	// ��������У��
	if (repeat) return repeat;
	if (typeof config === 'string' || config.nodeType === 1) config = {content: config, fixed: !_isMobile};
	if (!$.isArray(config.button)) config.button = config.button ? [config.button] : [];
	if (!config.id) config.id = _expando + (_count ++);
	if (_isMobile) config.fixed =  false;
	
	// �ϲ�Ĭ������
	for (i in defaults) {
		if (config[i] === undefined) config[i] = defaults[i];		
	};
	
	// ����Ԫ��
	follow = config.follow || this;
	if (typeof follow === 'string') follow = $(follow)[0];
	if (follow.nodeType === 1) {
		followApi = artDialog.list[follow[_expando + 'follow']];
		if (followApi) {
			return followApi.follow(follow).zIndex().focus();
		} else {
			config.follow = follow;
			follow[_expando + 'follow'] = config.id;
		};
	};
	
	// ���ð�ť�ϲ�������
	yesFn = yesFn || config.yesFn;
	noFn = noFn || config.noFn;
	yesFn && config.button.push({
		name: config.yesText,
		callback: yesFn,
		focus: true
	});
	noFn && config.button.push({
		name: config.noText,
		callback: noFn
	});
	
	// zIndexȫ������
	artDialog.defaults.zIndex = config.zIndex;
	
	return artDialog.list[config.id] = _oldApi ?
		_oldApi._init(config, true) : new artDialog.fn._init(config);
};

artDialog.fn = artDialog.prototype = {

	version: '4.0.2',
	
	_init: function (config, isReset) {
		var that = this;
		
		that.config = config;
		that._isClose = false;
		that._listeners = {};
		that._minWidth = config.minWidth;
		that._minHeight = config.minHeight;
		that._fixed = _isIE6 ? false : config.fixed;
		
		if (!isReset) {
			that._wrap = document.createElement('div');
			that.DOM = {
				wrap: $(that._wrap)
			};
			that._outerTmpl();
		};
		
		that._wrap.style.cssText = 'position:absolute;left:0;top:0';
		that._innerTmpl();
		
		if (isReset) {
			_oldApi = null;
		} else {
			that._eventProxy();
		};
		
		that.size(config.width, config.height);
		config.follow ? that.follow(config.follow) : that.position(config.left, config.top);
		config.focus && that.focus();
		!config.show && that.hide();
		config.lock && that.lock();
		that.zIndex(config.zIndex).time(config.time);
		config.initFn && config.initFn.call(that, window);
		
		return that;
	},
	
	/**
	 * ��������
	 * @param	{String, HTMLElement, Object}	���� (��ѡ)
	 * @param	{String}						ģ�� (��ѡ, ��Ҫmsg��������Ϊ Object ������Ч)
	 * @return	this, HTMLElement				����޲����򷵻���������DOM����
	 */
	content: function (msg, tmpl) {
		var prev, parent, width, height, display,
			that = this,
			content = that.DOM.content,
			elem = content[0];
		
		that._elemBack = $.noop;
		
		if (!msg && msg !== 0) {
			return elem;
		} else if (tmpl) {
			elem.innerHTML = _tmplEngine(tmpl, msg);
		} else if (typeof msg === 'string') {
			content.html(msg);
		} else if (msg.nodeType === 1) {
		
			// �ô����Ԫ���ڶԻ���رպ���Է��ص�ԭ���ĵط�
			display = msg.style.display;
			prev = msg.previousSibling;
			next = msg.nextSibling;
			parent = msg.parentNode;
			that._elemBack = function () {
				if (prev && prev.parentNode) {
					prev.parentNode.insertBefore(msg, prev.nextSibling);
				} else if (next && prev.parentNode) {
					next.parentNode.insertBefore(msg, next);
				} else if (parent) {
					parent.appendChild(msg);
				};
				msg.style.display = display;
			};
			
			elem.innerHTML = '';
			elem.appendChild(msg);
			msg.style.display = 'block';
			
		};
		
		_isIE6 && that._selectFix();
		that._runScript(elem);
		
		return that;
	},
	
	/**
	 * ���ñ���
	 * @param	{String}			��������
	 * @return	this, HTMLElement	����޲����򷵻�������DOM����
	 */
	title: function (text) {
		var DOM = this.DOM,
			titleWrap = DOM.titleWrap[0],
			title = DOM.title[0];
		if (text === undefined) {
			return title.innerHTML;
		} else {
			title.innerHTML = text;
		};
		titleWrap.style.display = 'block';
		return this;
	},
	
	/** λ�� */
	position: function (left, top) {
		var scaleLeft, scaleTop,
			that = this,
			wrap = that.DOM.wrap,
			ie6Fixed = _isIE6 && that.config.fixed,
			docLeft = _$document.scrollLeft(),
			docTop = _$document.scrollTop(),
			dl = that._fixed ? 0 : docLeft,
			dt = that._fixed ? 0 : docTop,
			ww = _$window.width(),
			wh = _$window.height(),
			ow = wrap[0].offsetWidth,
			oh = wrap[0].offsetHeight,
			style = wrap[0].style;
		
		if (!left && left !== 0) left = that._scaleLeft;
		if (!top && top !== 0) top = that._scaleTop;
			
		// ת��left�ٷֱ�ֵΪ��ֵ
		if (typeof left === 'string') {
			scaleLeft = that._toNumber(left, ww - ow);
			if (scaleLeft !== null) {
				that._scaleLeft = left;
				left = scaleLeft + dl;
			};
		} else if (ie6Fixed && typeof left === 'number') {
			left += docLeft;
		};

		// �ƽ������ֱ����
		if (top === 'goldenRatio') {
			that._scaleTop = top;
			top = Math.max(Math.min((oh < 4 * wh / 7 ?
				wh * 0.382 - oh / 2 :
				(wh - oh) / 2) + dt, wh - oh + dt), dt);
		
		// ת��top�ٷֱ�ֵΪ��ֵ
		} else if (typeof top === 'string') {
			scaleTop = that._toNumber(top, wh - oh);
			if (scaleTop !== null) {
				that._scaleTop = top;
				top = scaleTop + dt;
			};
		} else if (ie6Fixed && typeof top === 'number') {
			top += docTop;
		};

		if (typeof left === 'number') style.left = left + 'px';
		if (typeof top === 'number') style.top = top + 'px';
		
		that._autoPositionType();
		
		return that;
	},
	
	/**
	 *	�ߴ�
	 *	@param	{Number, String}	���
	 *	@param	{Number, String}	�߶�
	 */
	size: function (width, height) {
		var maxWidth, maxHeight, scaleWidth, scaleHeight,
			that = this,
			DOM = that.DOM,
			wrap = DOM.wrap,
			main = DOM.main,
			wrapStyle = wrap[0].style,
			style = main[0].style;
			
		if (!width && width !== 0) width = that._scaleWidth;
		if (!height && height !== 0) height = that._scaleHeight;
				
		// ת����Ȱٷֱ�Ϊ��ֵ
		if (typeof width === 'string') {
			maxWidth = _$window.width() - wrap[0].offsetWidth + main[0].offsetWidth;
			scaleWidth = that._toNumber(width, maxWidth);
			if (scaleWidth !== null) {
				that._scaleWidth = width;
				width = scaleWidth;
			} else if (width.indexOf('px') !== -1) {
				width = parseInt(width);
			};
		};
		
		// ת���߶Ȱٷֱ�Ϊ��ֵ
		if (typeof height === 'string') {
			maxHeight = _$window.height() - wrap[0].offsetHeight + main[0].offsetHeight;
			scaleHeight = that._toNumber(height, maxHeight);
			if (scaleHeight !== null) {
				that._scaleHeight = height;
				height = scaleHeight;
			} else if (height.indexOf('px') !== -1) {
				height = parseInt(height);
			};
		};
		
		if (typeof width === 'number') {
			wrapStyle.width = 'auto';
			style.width = Math.max(that._minWidth, width) + 'px';
			wrapStyle.width = wrap[0].offsetWidth + 'px'; // ��ֹδ�����ȵı������������ұ߽߱�����
		} else if (typeof width === 'string') {
			style.width = width;
			width === 'auto' && wrap.css('width', 'auto');
		};
		
		if (typeof height === 'number') {
			style.height = Math.max(that._minHeight, height) + 'px';
		} else if (typeof height === 'string') {
			style.height = height;
		};
		
		_isIE6 && that._selectFix();
		
		return that;
	},
	
	/** ����Ԫ�� */
	follow: function (elem) {
		if (typeof elem === 'string' || elem && elem.nodeType === 1) {
			elem = $(elem);
		};
		if (!elem || !elem[0] || elem.css('display') === 'none') {
			return this.position(that.config.left, that.config.top);
		};
		
		var that = this,
			winWidth = _$window.width(),
			winHeight = _$window.height(),
			docLeft =  _$document.scrollLeft(),
			docTop = _$document.scrollTop(),
			offset = elem.offset(),
			width = elem[0].offsetWidth,
			height = elem[0].offsetHeight,
			left = that._fixed ? offset.left - docLeft : offset.left,
			top = that._fixed ? offset.top - docTop : offset.top,
			wrap = that.DOM.wrap[0],
			style = wrap.style,
			wrapWidth = wrap.offsetWidth,
			wrapHeight = wrap.offsetHeight,
			setLeft = left - (wrapWidth - width) / 2,
			setTop = top + height,
			dl = that._fixed ? 0 : docLeft,
			dt = that._fixed ? 0 : docTop;
			
		if (setLeft + wrapWidth > winWidth) {
			setLeft = left - wrapWidth + width;
		};
		if (setLeft < dl) {
			setLeft = left;
		};
		if (setTop + wrapHeight > winHeight + dt) {
			setTop = top - wrapHeight;
		};
		
		style.left = setLeft + 'px';
		style.top = setTop + 'px';
		
		that.config.follow = elem;
		that._autoPositionType();
		return that;
	},
	
	/**
	 * �Զ��尴ť
	 * @example
				 button({
					name: 'login',
					callback: function () {},
					disabled: false,
					focus: true
				}, .., ..)
	 */
	button: function (/* @augments */) {
		var that = this,
			ags = arguments,
			elem = that.DOM.buttons[0],
			list = $.isArray(ags[0]) ? ags[0] : [].slice.call(ags);
		
		if (!list.length) {
			elem.style.display = 'none';
			return that;
		};
		
		$.each(list, function (i, val) {
			var name = val.name,
				listeners = that._listeners,
				strongButton = 'aui_strongButton',
				isNewButton = !listeners[name],
				button = !isNewButton ?
					listeners[name].elem :
					document.createElement('button');
					
			if (!listeners[name]) listeners[name] = {};
			if (val.callback) listeners[name].callback = val.callback;
			if (val.className) button.className = val.className;
			if (val.focus) {
				that._focus && that._focus.removeClass(strongButton);
				that._focus = $(button).addClass(strongButton);
				that.focus();
			};
			
			button[_expando + 'callback'] = name;
			button.disabled = !!val.disabled;

			if (isNewButton) {
				button.innerHTML = name;
				listeners[name].elem = button;
				elem.appendChild(button);
			};
		});
		
		elem.style.display = 'block';
		_isIE6 && that._selectFix();
		
		return that;
	},
	
	/** ��ʾ�Ի��� */
	show: function () {
		this._wrap.style.display = 'block';
		return this;
	},
	
	/** ���ضԻ��� */
	hide: function () {
		this._wrap.style.display = 'none';
		return this;
	},
	
	/** �رնԻ��� */
	close: function () {
		var that = this,
			DOM = that.DOM,
			list = artDialog.list,
			fn = that.config.closeFn;
		
		if (that._isClose) return that;
		that.time();
		if (typeof fn === 'function' && fn.call(that, window) === false) {
			return that;
		};
		
		that.unlock();
		
		that._elemBack();
		that._setAbsolute();
		that._timer = that._focus = null;
		that._scaleLeft = that._scaleTop = null;
		that._scaleWidth = that._scaleHeight = null;
		DOM.wrap[0].style.cssText = '';
		DOM.center[0].innerHTML = '';
		DOM.outerTable[0].style.cssText = '';
		
		if (artDialog.focus === that) artDialog.focus = null;
		delete list[that.config.id];
		that._isClose = true;
		that.hide();
		
		if (!_oldApi) {
			_oldApi = that;
		} else {
			that._uneventProxy();
			that.DOM.wrap.remove();
		};
		
		return that;
	},
	
	/**
	 * ��ʱ�ر�
	 * @param	{Number}	��λΪ��, �޲�����ֹͣ��ʱ��
	 */
	time: function (second) {
		var that = this,
			cancel = that.config.noText,
			timer = that._timer;
			
		timer && clearTimeout(timer);
		
		if (second) {
			that._timer = setTimeout(function(){
				that._trigger(cancel);
			}, 1000 * second);
		};
		
		return that;
	},
	
	/** ����ť���ӽ��� */
	focus: function () {
		var elemFocus, content,
			that = this,
			config = that.config,
			DOM = that.DOM;
			
		elemFocus = that._focus && that._focus[0] || DOM.close[0];
		
		try {
			elemFocus && elemFocus.focus();
		} catch (e) {};
		
		return that;
	},
	
	/** �ö�z-index */
	zIndex: function () {
		var that = this,
			wrap = that.DOM.wrap,
			index = artDialog.defaults.zIndex ++,
			focusElem = artDialog.focus;
			
		wrap.css('zIndex', index);
		that._lockMask && that._lockMask.css('zIndex', index - 1);
		
		// ������߲����ʽ
		if (focusElem) focusElem.DOM.wrap.removeClass('aui_focus');
		artDialog.focus = that;
		wrap.addClass('aui_focus');
		
		return that;
	},
	
	/** �������� */
	lock: function () {
		if (this._lock) return this; // ȫ��ֻ����һ������
		
		var that = this,
			index = artDialog.defaults.zIndex += 2,
			wrap = that.DOM.wrap,
			config = that.config,
			docWidth = _$document.width(),
			docHeight = _$document.height(),
			lockMaskWrap = that._lockMaskWrap || $(_$body[0].appendChild(document.createElement('div'))),
			lockMask = that._lockMask || $(lockMaskWrap[0].appendChild(document.createElement('div'))),
			domTxt = '(document).documentElement',
			sizeCss = _isMobile ? 'width:' + docWidth + 'px;height:' + docHeight
				+ 'px' : 'width:100%;height:100%',
			ie6Css = _isIE6 ?
				'position:absolute;left:expression(' + domTxt + '.scrollLeft);top:expression('
				+ domTxt + '.scrollTop);width:expression(' + domTxt
				+ '.clientWidth);height:expression(' + domTxt + '.clientHeight)'
			: '';
		
		wrap.css('zIndex', index);
		
		lockMaskWrap[0].style.cssText = sizeCss + ';position:fixed;z-index:'
			+ (index - 1) + ';top:0;left:0;overflow:hidden;' + ie6Css;
		lockMask[0].style.cssText = 'height:100%;background:' + config.background
			+ ';filter:alpha(opacity=0);opacity:0';
		
		// ��IE6���������ܹ���ס�����ؼ�
		if (_isIE6) lockMask[0].innerHTML =
			'<iframe src="about:blank" style="width:100%;height:100%;position:absolute;' +
			'top:0;left:0;z-index:-1;filter:alpha(opacity=0)"></iframe>';
			
		lockMask.animate({opacity: config.opacity}, config.duration);
		lockMask[0].ondblclick = function () {
			that.close();
		};
		
		that._lockMaskWrap = lockMaskWrap;
		that._lockMask = lockMask;
		
		that._lock = true;
		return that;
	},
	
	/** �⿪���� */
	unlock: function () {
		var that = this;
		
		if (!that._lock) return;
		var style = that._lockMaskWrap[0].style;
		
		that._lockMask[0].ondblclick = null;
		that._lockMask.animate({opacity: 0}, that.config.duration, function () {
			if (_isIE6) {
				style.removeExpression('width');
				style.removeExpression('height');
				style.removeExpression('left');
				style.removeExpression('top');
			};
			style.cssText = 'display:none';
			
			if (_oldApi) {
				that._lockMaskWrap.remove();
				that._lockMaskWrap = that._lockMask = null;
			};
			that._lock = false;
		});

		return that;
	},
	
	// �������νṹ ���ɱ��ظ�ʹ�ã�
	_outerTmpl: function () {
		var that = this,
			wrap = that._wrap;
			
		wrap.innerHTML = _tmplEngine('outer', that.config);
		document.body.appendChild(wrap);
		
		that._getDOM('outer|outerTable|nw|n|ne|w|center|e|sw|s|se'.split('|'));
		_isIE6 && that._pngFix();
	},
	
	// ������������ ��ÿ�ν����أ�
	_innerTmpl: function () {
		var that = this,
			config = that.config,
			DOM = that.DOM;
		
		DOM.center[0].innerHTML = _tmplEngine('inner', config);
		that._getDOM('inner|header|titleWrap|title|close|main|content|buttons'.split('|'));
		DOM.se.css('cursor', config.resize ? 'se-resize' : 'auto');
		DOM.title.css('cursor', config.drag ? 'move' : 'auto');
		
		that.button(config.button).content(config.content, config.tmpl);
	},
	
	// ��ȡҳ����������
	/* _getScrollWidth: function () {
		var html = _$html[0],
			css = html.style.overflow,
			oldWidth = html.clientWidth,
			newWidth = oldWidth;
			
		html.style.overflow = 'hidden';
		newWidth = html.clientWidth;
		html.style.overflow = css;
		return newWidth - oldWidth;
	}, */
	
	// �ٷֱ�ת������ֵ
	_toNumber: function (scale, length) {
		return scale.indexOf('%') !== -1 ?
			parseInt(length * scale.split('%')[0] / 100) : null;
	},
	
	// ��IE6 CSS֧��PNG����
	_pngFix: function () {
		
		// ���CSS���
		if (!this.DOM.outer[0].currentStyle['ie6PngFix']) return;
	
		var i = 0, elem, png, pngPath,
			path = artDialog.defaults.path + '/skins/',
			list = this.DOM.wrap[0].getElementsByTagName('*');
		
		for (; i < list.length; i ++) {
			elem = list[i];
			png = elem.currentStyle['png'];
			if (png) {
				pngPath = path + png;
				elem.style.backgroundImage = 'none';
				elem.style.p = pngPath;
				elem.runtimeStyle.filter = "progid:DXImageTransform.Microsoft." +
					"AlphaImageLoader(src='" + pngPath + "',sizingMethod='crop')";
			};
		};
		elem = null;
	},
	
	// ǿ�Ƹ���IE6�����ؼ�
	_selectFix: function () {
		var elem = this.DOM.wrap[0],
			expando = _expando + 'iframeMask',
			iframe = elem[expando],
			width = elem.offsetWidth,
			height = elem.offsetHeight,
			left = - (width - elem.clientWidth) / 2 + 'px',
			top = - (height - elem.clientHeight) / 2 + 'px';

		width = width + 'px';
		height = height + 'px';
		
		if (iframe) {
			iframe.style.width = width;
			iframe.style.height = height;
		} else {
			iframe = elem.appendChild(document.createElement('iframe'));
			elem[expando] = iframe;
			iframe.src = 'about:blank';
			iframe.style.cssText = 'position:absolute;z-index:-1;left:'
				+ left + ';top:' + top
				+ ';width:' + width + ';height:' + height
				+ ';filter:alpha(opacity=0)';
		};
	},
	
	// ��ȡDOM
	_getDOM: function (list) {
		var DOM = this.DOM,
			wrap = DOM.wrap;
			
		for (var i in list) {
			DOM[list[i]] = wrap.find('.aui_' + list[i]);
		};
	},
	
	// ����HTMLƬ�����Զ������ͽű�:
	// <script type="text/dialog"></script>
	_runScript: function (elem) {
		var fun, i = 0, n = 0,
			tags = elem.getElementsByTagName('script'),
			length = tags.length,
			script = [];
			
		for (; i < length; i ++) {
			if (tags[i].type === 'text/dialog') {
				script[n] = tags[i].innerHTML;
				n ++;
			};
		};
		
		if (script.length) {
			script = script.join('');
			fun = new Function(script);
			fun.call(this);
		};
	},
	
	// �Զ��л���λ����
	_autoPositionType: function () {
		var that = this;
		that[that.config.fixed ? '_setFixed' : '_setAbsolute']();
	},
	
	
	// ���þ�ֹ��λ
	// IE6 Fixed @see: http://www.planeart.cn/?p=877
	_setFixed: (function () {
		_isIE6 && $(function () {
			var bg = 'backgroundAttachment';
			if (_$html.css(bg) !== 'fixed' && _$body.css(bg) !== 'fixed') {
				_$html.css({
					backgroundImage: 'url(about:blank)',
					backgroundAttachment: 'fixed'
				});
			};
		});
		
		return function () {
			var $elem = this.DOM.wrap,
				style = $elem[0].style;
			
			if (_isIE6) {
				var left = parseInt($elem.css('left')),
					top = parseInt($elem.css('top')),
					sLeft = _$document.scrollLeft(),
					sTop = _$document.scrollTop(),
					txt = '(document.documentElement)';
				
				this._setAbsolute();
				style.setExpression('left', 'eval(' + txt + '.scrollLeft + '
					+ (left - sLeft) + ') + "px"');
				style.setExpression('top', 'eval(' + txt + '.scrollTop + '
					+ (top - sTop) + ') + "px"');
			} else {
				style.position = 'fixed';
			};
		};
	}()),
	
	
	// ���þ��Զ�λ
	_setAbsolute: function () {
		var style = this.DOM.wrap[0].style;
			
		if (_isIE6) {
			style.removeExpression('left');
			style.removeExpression('top');
		};

		style.position = 'absolute';
	},
	
	// ��ť�¼�����
	_trigger: function (id) {
		var that = this,
			fn = that._listeners[id] && that._listeners[id].callback;
		return typeof fn !== 'function' || fn.call(that, window) !== false ?
			that.close() : that;
	},
	
	// �¼�����
	_eventProxy: function () {
		var winResize, resizeTimer,
			that = this,
			DOM = that.DOM,
			winSize = _$window.width() * _$window.height();
		
		// �������
		DOM.wrap.bind('click', function (event) {
			var target = event.target, callbackID;
			
			if (target.disabled) return false; // IE BUG
			
			if (target === DOM.close[0]) {
				that._trigger(that.config.noText);
				return false;
			} else {
				callbackID = target[_expando + 'callback'];
				callbackID && that._trigger(callbackID);
			};
		}).bind('mousedown', function () {
			that.zIndex();
		});
		
		// ���ڵ����¼�
		winResize = function () {
			var newSize,
				oldSize = winSize,
				elem = that.config.follow,
				width = that._scaleWidth,
				height = that._scaleHeight,
				left = that._scaleLeft,
				top = that._scaleTop;
			
			if ('all' in document) {
				// IE6~7 window.onresize bug
				newSize = _$window.width() * _$window.height();
				winSize = newSize;
				if (oldSize === newSize) return;
			};
			
			if (width || height) that.size(width, height);
			
			if (elem) {
				that.follow(elem);
			} else if (left || top) {
				that.position(left, top);
			};
		};
		
		that._winResize = function () {
			resizeTimer && clearTimeout(resizeTimer);
			resizeTimer = setTimeout(function () {
				winResize();
			}, 40);
		};
		
		_$window.bind('resize', that._winResize);
	},
	
	// ж���¼�����
	_uneventProxy: function () {
		var that = this,
			DOM = that.DOM;
		
		DOM.wrap.unbind('click').unbind('mousedown');
		_$window.unbind('resize', that._winResize);
	}
	
};

artDialog.fn._init.prototype = artDialog.fn;
$.fn.dialog = $.fn.artDialog = function () {
	var config = arguments;
	this[this.live ? 'live' : 'bind']('click', function () {
		artDialog.apply(this, config);
		return false;
	});
	return this;
};



/** ���ĶԻ���API */
artDialog.focus = null;



/** �Ի����б� */
artDialog.list = {};



// ΢��ģ������ - JavaScript Micro-Templating
// @see http://ejohn.org/blog/javascript-micro-templating/
_tmplEngine = (function(){
	var cache = {};
	return function tmpl(str, data){
		var fn = !/\W/.test(str) ?
		  cache[str] = cache[str] ||
			tmpl(artDialog.templates[str]) :
		  new Function("obj",
			"var p=[],print=function(){p.push.apply(p,arguments);};" +
			"with(obj){p.push('" +
			str
			  .replace(/[\r\t\n]/g, " ")
			  .split("<%").join("\t")
			  .replace(/((^|%>)[^\t]*)'/g, "$1\r")
			  .replace(/\t=(.*?)%>/g, "',$1,'")
			  .split("\t").join("');")
			  .split("%>").join("p.push('")
			  .split("\r").join("\\'")
		  + "');}return p.join('');");
		return data ? fn(data) : fn;
	};
})();



// ȫ�ֿ�ݼ�
_$document.bind('keydown', function (event) {
	var target = event.target,
		nodeName = target.nodeName,
		rinput = /^INPUT|TEXTAREA$/,
		api = artDialog.focus,
		keyCode = event.keyCode;

	if (!api || !api.config.esc || rinput.test(nodeName)) return;
		
	keyCode === 27 && api._trigger(api.config.noText);
});



// ��ȡartDialog·��
_path = window['_artDialog_path'] || (function (script, i, me) {
	for (i in script) {
		// ���ͨ���������ű����������ر��ļ����뱣֤�ļ�������"artDialog"�ַ�
		if (script[i].src && script[i].src.indexOf('artDialog') !== -1) me = script[i];
	};
	
	_thisScript = me || script[script.length - 1];
	me = _thisScript.src.replace(/\\/g, '/');
	return me.lastIndexOf('/') < 0 ? '.' : me.substring(0, me.lastIndexOf('/'));
}(document.getElementsByTagName('script')));




// ����������CSS (��"artDialog.min.js?skin=aero")
_skin = window['_artDialog_skin'] || _thisScript.src.split('skin=')[1];
if (_skin) {
	var link = document.createElement('link');
	link.rel = 'stylesheet';
	link.href = _path + '/skins/' + _skin + '.css';
	$('head')[0].appendChild(link);
};



// ���������Ԥ�Ȼ��汳��ͼƬ
_$window.bind('load', function () {
	setTimeout(function () {
		if (!_count) {
			artDialog({left:-9999, time: 9, focus: false});
		};
	}, 150);
});



// ����IE6 CSS����ͼƬ����
try {
	document.execCommand('BackgroundImageCache', false, true);
} catch (e) {};



/** ģ�� */
artDialog.templates = {

	// Template: UI Framework
	outer: [
	'<div class="aui_outer">',
		'<table class="aui_table aui_outerTable">',
			'<tr>',
				'<td class="aui_border aui_nw"></td>',
				'<td class="aui_border aui_n"></td>',
				'<td class="aui_border aui_ne"></td>',
			'</tr>',
			'<tr>',
				'<td class="aui_border aui_w"></td>',
				'<td class="aui_center"></td>',
				'<td class="aui_border aui_e"></td>',
			'</tr>',
			'<tr>',
				'<td class="aui_border aui_sw"></td>',
				'<td class="aui_border aui_s"></td>',
				'<td class="aui_border aui_se"></td>',
			'</tr>',
		'</table>',
	'</div>'].join(''),
	
	// Template: Content Framework
	inner: [
	'<table class="aui_table aui_inner">',
		'<tr>',
			'<td <% if (icon) { %>colspan="2"<% } %> class="aui_header">',
				'<div class="aui_titleWrap" <% if (title === false) { %>style="display:none"<% } %>>',
					'<div class="aui_title">',
						'<%=title%>',
					'</div>',
					'<a class="aui_close" href="javascript:/*artDialog*/;"><%=closeText%></a>',
				'</div>',
			'</td>',
		'</tr>',
		'<tr>',
			'<% if (icon) { %>',
			'<td class="aui_tdIcon">',
				'<div class="aui_icon aui_<%=icon%>" style="',
					'background:url(<%=path%>/skins/icons/<%=icon%>.png) no-repeat center center;',
					'_background:none;_filter: progid:DXImageTransform.Microsoft.AlphaImageLoader',
					'(src=<%=path%>/skins/icons/<%=icon%>.png,sizingMethod=crop)',
				'"></div>',
			'</td>',
			'<% } %>',
			'<td class="aui_main">',
				'<div class="aui_content" style="padding:<%=padding%>"></div>',
			'</td>',
		'</tr>',
		'<tr>',
			'<td <% if (icon) { %>colspan="2"<% } %> class="aui_footer">',
				'<div class="aui_buttons" style="display:none"></div>',
			'</td>',
		'</tr>',
	'</table>'].join('')

};



/**
 * Ĭ������
 * @namespace
 */
artDialog.defaults = {

	content: '<div class="aui_loading"><span>loading..</span></div>',
	title: '\u6d88\u606f',		// ����. Ĭ��'��Ϣ'
	tmpl: null,					// �������������ģ��
	button: null,				// �Զ��尴ť
	yesFn: null,				// ȷ����ť�ص�����
	noFn: null,					// ȡ����ť�ص�����
	yesText: '\u786E\u5B9A',	// ȷ����ť�ı�. Ĭ��'ȷ��'
	noText: '\u53D6\u6D88',		// ȡ����ť�ı�. Ĭ��'ȡ��'
	closeText: '\xd7',			// �رհ�ť�ı�. Ĭ��'��'
	width: 'auto',				// ���ݿ��
	height: 'auto',				// ���ݸ߶�
	minWidth: 96,				// ��С�������
	minHeight: 32,				// ��С�߶�����
	padding: '20px 25px',		// ������߽�������
	icon: null,					// ��Ϣͼ������
	initFn: null,				// �Ի����ʼ����ִ�еĺ���
	closeFn: null,				// �Ի���ر�ִ�еĺ���
	time: null,					// �Զ��ر�ʱ��
	esc: true,					// �Ƿ�֧��Esc���ر�
	focus: true,				// �Ƿ�֧�ֶԻ���ť�۽�
	show: true,					// ��ʼ�����Ƿ���ʾ�Ի���
	plug: true,					// �Ƿ�ִ�в��
	follow: null,				// ����ĳԪ��
	path: _path,				// artDialog·��
	lock: false,				// �Ƿ�����
	background: '#000',			// ������ɫ
	opacity: .7,				// ����͸����
	duration: 300,				// ����͸���Ƚ��䶯���ٶ�
	fixed: false,				// �Ƿ�ֹ��λ
	left: '50%',				// X������
	top: 'goldenRatio',			// Y������
	zIndex: 1987,				// �Ի�����Ӹ߶�ֵ(��Ҫ����ֵ���ܳ���������������)
	resize: true,				// �Ƿ������û����ڳߴ�
	drag: true					// �Ƿ������û��϶�λ��
	
};

window.artDialog = $.dialog = $.artDialog = artDialog;
}((window.jQuery && (window.art = jQuery)) || window.art, this));







/*!
	��ѡ����ģ�飺�öԻ���֧����ק
------------------------------------------------------------------*/
;(function ($) {

var _dragEvent, _use,
	_$window = $(window),
	_$document = $(document),
	_elem = document.documentElement,
	_isLosecapture = 'onlosecapture' in _elem,
	_isSetCapture = 'setCapture' in _elem,
	_isIE6 = !-[1,] && !('minWidth' in _elem.style);


// ��ק�¼�
artDialog.dragEvent = function () {
	var that = this,
		proxy = function (name) {
			var fn = that[name];
			that[name] = function () {
				return fn.apply(that, arguments);
			};
		};
		
	proxy('start');
	proxy('drag');
	proxy('stop');
};

artDialog.dragEvent.prototype = {

	// ��ʼ��ק
	onstart: $.noop,
	start: function (event) {
		var that = this;
		_$document
			.bind('mousemove', that.drag)
			.bind('mouseup', that.stop)
			.bind('dblclick', that.stop);
			
		that._clientX = event.clientX;
		that._clientY = event.clientY;
		that.onstart(event.clientX, event.clientY);
		event.preventDefault();
	},
	
	// ������ק
	ondrag: $.noop,
	drag: function (event) {
		var that = this;
		that.ondrag(
			event.clientX - that._clientX,
			event.clientY - that._clientY
		);
	},
	
	// ������ק
	onstop: $.noop,
	stop: function (event) {
		var that = this;
		_$document
			.unbind('mousemove', that.drag)
			.unbind('mouseup', that.stop)
			.unbind('dblclick', that.stop);
		
		event && that.onstop(event.clientX, event.clientY);
	}
	
};


_use = function (event) {
	var limit, startWidth, startHeight, startLeft, startTop, isResize,
		api = artDialog.focus,
		config = api.config,
		DOM = api.DOM,
		wrap = DOM.wrap,
		title = DOM.title,
		main = DOM.main;

	// ����ı�ѡ��
	var clsSelect = 'getSelection' in window ? function () {
		window.getSelection().removeAllRanges();
	} : function () {
		try {
			document.selection.empty();
		} catch (e) {};
	};
	
	// �Ի���׼���϶�
	_dragEvent.onstart = function (x, y) {
		if (isResize) {
			startWidth = main[0].offsetWidth;
			startHeight = main[0].offsetHeight;
		} else {
			startLeft = parseInt(wrap.css('left'));
			startTop = parseInt(wrap.css('top'));
		};
		
		!_isIE6 && _isLosecapture ?
			title.bind('losecapture', api.stop) :
			_$window.bind('blur', api.stop);
		_isSetCapture && title[0].setCapture();
		
		wrap.addClass('aui_drag');
		api.focus();
	};
	
	// �Ի����϶�������
	_dragEvent.ondrag = function (x, y) {
		if (isResize) {
			var wrapStyle = wrap[0].style,
				style = main[0].style,
				width = x + startWidth,
				height = y + startHeight;
			
			wrapStyle.width = 'auto';
			style.width = Math.max(api._minWidth, width) + 'px';
			wrapStyle.width = wrap[0].offsetWidth + 'px';
			style.height = Math.max(api._minHeight, height) + 'px';
		} else {
			var style = wrap[0].style,
				left = x + startLeft,
				top = y + startTop;

			style.left = Math.max(limit.minX, Math.min(limit.maxX, left)) + 'px';
			style.top = Math.max(limit.minY, Math.min(limit.maxY, top)) + 'px';
		};
			
		clsSelect();
		_isIE6 && api._selectFix();
	};
	
	// �Ի����϶�����
	_dragEvent.onstop = function (x, y) {
		!_isIE6 && _isLosecapture ?
			title.unbind('losecapture', api.stop) :
			_$window.unbind('blur', api.stop);
		_isSetCapture && title[0].releaseCapture();
		
		_isIE6 && api._autoPositionType();
		
		wrap.removeClass('aui_drag');
	};
	
	isResize = event.target === DOM.se[0] ? true : false;
	limit = (function () {
		var maxX, maxY,
			wrap = api.DOM.wrap[0],
			ow = wrap.offsetWidth,
			oh = wrap.offsetHeight,
			ww = _$window.width(),
			wh = _$window.height(),
			dl = api._fixed ? 0 : _$document.scrollLeft(),
			dt = api._fixed ? 0 : _$document.scrollTop(),
			
		// �������ֵ����
		maxX = ww - ow + dl;
		maxY = wh - oh + dt;
		
		return {
			minX: dl,
			minY: dt,
			maxX: maxX,
			maxY: maxY
		};
	})();
	
	_dragEvent.start(event);
};

// ���� mousedown �¼������Ի����϶�
_$document.bind('mousedown', function (event) {
	var api = artDialog.focus;
	if (!api) return;

	var target = event.target,
		config = api.config,
		DOM = api.DOM;
	
	if (config.drag && target === DOM.title[0]
	|| config.resize && target === DOM.se[0]) {
		_dragEvent = _dragEvent || new artDialog.dragEvent();
		_use(event);
	};
});

})(window.jQuery || window.art);


