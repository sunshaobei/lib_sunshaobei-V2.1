package share.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * WXEntryActivity 是微信固定的Activiy、 不要改名字、并且放到你对应的项目报名下面、
 * 例如： ....(package报名).wxapi.WXEntryActivity
 * 不然无法回调、切记...
 * Wx  回调接口 IWXAPIEventHandler
 * <p/>
 * 关于WXEntryActivity layout。 我们没给页面、而是把Activity  主题 android:theme="@android:style/Theme.Translucent" 透明、
 * <p/>
 * User: MoMo - Nen
 * Date: 2015-10-24
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI mApi;

    private int mTargetScene = SendMessageToWX.Req.WXSceneSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApi = WXAPIFactory.createWXAPI(this, Param.APP_ID, true);
//        mApi.handleIntent(this.getIntent(), this);
        mApi.registerApp(Param.APP_ID);
    }


    //微信发送的请求将回调到onReq方法
    @Override
    public void onReq(BaseReq baseReq) {
    }

    //发送到微信请求的响应结果
    @Override
    public void onResp(BaseResp resp) {
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
                Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
                break;
        }
        finish();
    }
}