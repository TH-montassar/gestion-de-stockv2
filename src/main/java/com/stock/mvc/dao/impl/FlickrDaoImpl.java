package com.stock.mvc.dao.impl;

import java.io.InputStream;
import javax.swing.JOptionPane;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import com.stock.mvc.dao.IFlickrDao;


public class FlickrDaoImpl implements IFlickrDao  {
	
	private Flickr flickr;
	
	private UploadMetaData uploadMetaData = new UploadMetaData();
	
	private String apiKey = "953750ca69987f5081bc93cb692f8508";
	
	private String sharedSecret = "004055482db5d549";
	
	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157719508365021-8dae8695afaea2be");
		auth.setTokenSecret("9f3662620deb1640");
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}
	

	@Override
	public String savePhoto(InputStream photo, String title) throws Exception {
		connect();
		uploadMetaData.setTitle(title);
		String photoId = flickr.getUploader().upload(photo , uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
	
	public void auth() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		 Flickr.debugStream = false;
		AuthInterface authInterface = flickr.getAuthInterface();

        OAuth1RequestToken requestToken = authInterface.getRequestToken();
        System.out.println("token: " + requestToken);
		
        String url = authInterface.getAuthorizationUrl(requestToken, Permission.DELETE);
        System.out.println("Follow this URL to authorise yourself on Flickr");
		System.out.println(url);
		System.out.println("paste in the token it gives you");
		System.out.println(">>");
		
		String tokenKey = JOptionPane.showInputDialog(null) ;

        OAuth1Token accessToken = authInterface.getAccessToken(requestToken, tokenKey);
        System.out.println("Authentication success");
			
		Auth auth =null;
		try {
			 auth = authInterface.checkToken(accessToken);
		}catch(FlickrException e) {
			e.printStackTrace();
		}
		
		// this token can be used until the user revoker it.
		System.out.println("Token: "+ accessToken.getToken());
		System.out.println("Secret: "+ accessToken.getTokenSecret());
		System.out.println("nsid: "+ auth.getUser().getId());
		System.out.println("Realname: "+ auth.getUser().getRealName());
		System.out.println("Username: "+ auth.getUser().getUsername());
		System.out.println("Permission: "+ auth.getPermission());
			
	}
}