package adapter.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by sunshaobei on 2017/4/26.
 */

public abstract class LvAdapter2<T,T2> extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<T> list;
    private List <T2>list2;
    private int itemLayout;
    private int itemLayout2;

    public LvAdapter2(Context context, List<T> list, List<T2> list2, int itemLayout,int itemLayout2) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.list2 = list2;
        this.itemLayout = itemLayout;
        this.itemLayout2 = itemLayout2;
    }

    public Context getContext() {
        return context;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (position<list.size())
            return 0;
        else return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return list.size()+list2.size();
    }

    @Override
    public Object getItem(int position) {
        if (position<list.size())
        return list.get(position);
        else return list2.get(position-list.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (position<list.size())
        {
            viewHolder = getViewHolder(convertView, parent,itemLayout);
            convert(viewHolder, (T) getItem(position), position);
        }else {
            viewHolder = getViewHolder(convertView, parent,itemLayout2);
            convert2(viewHolder,(T2)getItem(position) ,position);
        }
        return viewHolder.getHoldView();
    }

    protected abstract void convert(ViewHolder viewHolder, T item, int position);
    protected abstract void convert2(ViewHolder viewHolder, T2 item, int position);

    private ViewHolder getViewHolder(View view, ViewGroup viewGroup,int itemLayout) {
        return ViewHolder.get(context, view, viewGroup, itemLayout);
    }

    protected void ShortToast(String result) {
        Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
    }

}