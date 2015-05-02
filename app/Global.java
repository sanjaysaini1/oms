import play.Application;
import play.GlobalSettings;
import play.libs.F.Promise;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;


public class Global extends GlobalSettings {

	@Override
	public Promise<Result> onBadRequest(RequestHeader arg0, String arg1) {
		// TODO Auto-generated method stub
		return super.onBadRequest(arg0, arg1);
	}

	@Override
	public Promise<Result> onError(RequestHeader arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		return super.onError(arg0, arg1);
	}

	@Override
	public void onStart(Application arg0) {
		// TODO Auto-generated method stub
		super.onStart(arg0);
		
		//TODO When application starts populate the DB with dummy order data
		// Currently load from Fixture class
		
	}

	@Override
	public void onStop(Application arg0) {
		// TODO Auto-generated method stub
		super.onStop(arg0);
	}

	
	
}
