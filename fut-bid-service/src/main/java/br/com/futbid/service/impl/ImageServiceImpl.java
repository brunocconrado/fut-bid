package br.com.futbid.service.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.futbid.service.ImageService;
import br.com.futbid.service.thread.ImageLoader;

@Service
public class ImageServiceImpl implements ImageService {

    private static final Logger LOG = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Override
    public void loadImage(JPanel panel, String url) {

	try {

	    ImageLoader imageLoader = new ImageLoader();
	    imageLoader.setPanel(panel);
	    imageLoader.setUrl(new URL(url));
	    imageLoader.start();
	} catch (MalformedURLException e) {
	    LOG.warn("Was not possible to load image from: {}", url, e);
	}

    }

}
