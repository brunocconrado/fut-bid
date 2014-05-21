package br.com.futbid.web.enumeration;

public enum PageView {

    AUTHENTICATION("/html/authentication/index"),
    MAIN("/html/internal/internal-app"), 
    MAIN_CONTROLLER("/api/internal"), 
    USER_REGISTER("public/user/register"),
    UNAUTHORIZED_VIEW("/public/unauthorized"), 
    UNAUTHORIZED_INIT_VIEW("/api/unauthorized");

    private String view;

    private PageView(String view) {
	this.view = view;
    }
    
    public String getView() {
	return view;
    }
}
