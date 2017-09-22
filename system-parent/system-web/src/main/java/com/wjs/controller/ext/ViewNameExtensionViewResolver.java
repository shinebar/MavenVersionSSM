package com.wjs.controller.ext;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class ViewNameExtensionViewResolver implements ViewResolver, Ordered {

	private static final Log logger = LogFactory.getLog(ViewNameExtensionViewResolver.class);

    private int order = 0;

    Map<String, ViewResolver> viewResolvers = new HashMap<String, ViewResolver>();

    public View resolveViewName(String viewName, Locale locale) throws Exception {
        String viewExtension = StringUtils.getFilenameExtension(viewName);
        if (StringUtils.isEmpty(viewExtension)) {
            return null;
        }

        ViewResolver viewResolver = viewResolvers.get(viewExtension);
        if (viewResolver != null) {
            View view = viewResolver.resolveViewName(viewName, locale);
            if (logger.isDebugEnabled()) {
                logger.debug("Returning [" + view + "] based on view extension '"
                        + viewExtension + "'");
            }
            return view;
        }
        if (logger.isWarnEnabled()) {
            logger.warn("No view found with view extension[" + viewExtension + "]; returning null");
        }
        return null;
    }

    public void setViewResolvers(Map<String, ViewResolver> viewResolvers) {
        this.viewResolvers.putAll(viewResolvers);
    }

    public Map<String, ViewResolver> getViewResolvers() {
        return viewResolvers;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}
