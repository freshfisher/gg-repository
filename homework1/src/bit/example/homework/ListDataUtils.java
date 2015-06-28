/**
 * 
 */
package bit.example.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class ListDataUtils {
	public List<String> mZhenXinHua = new ArrayList<String>();
	public List<String> mDaMaoXian = new ArrayList<String>();
	public List<String> mNameList = new ArrayList<String>();
	private static ListDataUtils me = new ListDataUtils();

	private ListDataUtils() {
		mZhenXinHua.add("和男/女朋友进行到哪一步了");
		mZhenXinHua.add("最喜欢在座哪位异性 ");
		mZhenXinHua.add("内衣/裤颜色（这个，如果不太熟要慎用~）");
		mZhenXinHua.add("初吻年龄 ");
		mZhenXinHua.add("自己最丢人的事 ");
		mZhenXinHua.add(".最后一次发自内心的笑是什么时候？ ");
		mZhenXinHua.add("愿意为爱情牺牲到什么程度 ");
		mZhenXinHua.add("朋友和男/女朋友那个重要（这个是不是有点损……） ");
		mZhenXinHua.add("身上哪个部位最敏感 ");
		mZhenXinHua.add("如果有来生，你选择当？ ");
		mZhenXinHua.add("你会选择Having sex before marriage吗？ ");
		mZhenXinHua.add("如果让你选择做一个电影中的角色，你会选谁呢？ ");
		mZhenXinHua.add("如果有一天我和你吵架，你会怎么办？ ");
		mZhenXinHua.add("哭得最伤心的是哪一次？为什么？ ");
		mZhenXinHua.add("如果跟你喜欢的人约会，碰到前任的男（女）朋友，会有什么表现？ ");
		mZhenXinHua.add("如果有一天我对你说我爱上你了，你怎么办？ ");
		
		mDaMaoXian.add("背一位异性绕场一周 ");
		mDaMaoXian.add("唱青藏高原最后一句 ");
		mDaMaoXian.add("做一个大家都满意的鬼脸");
		mDaMaoXian.add("抱一位异性直到下一轮真心话大冒险结束 ");
		mDaMaoXian.add("像一位异性表白3分钟 ");
		mDaMaoXian.add("与一位异性十指相扣，对视10秒 ");
		mDaMaoXian.add("邀请一位异性为你唱情歌，或邀请一位异性与你情歌对唱 ");
		mDaMaoXian.add("做自己最性感、最妩媚的表情或动作 ");
		mDaMaoXian.add("吃下每个人为你夹得菜（如果是辣椒……） ");
		mDaMaoXian.add("跳草裙舞、脱衣舞（反正是冬天） ");
		mDaMaoXian.add("蹲在凳子上作便秘状 ");
		mDaMaoXian.add("亲***（这个人可以事先指定），或者亲一位异性，部位不限 ");
		mDaMaoXian.add("神情的吻墙10秒 ");
		mDaMaoXian.add("模仿古代特殊职业女子拉客 ");
		mDaMaoXian.add("模仿脑白金广告，边唱边跳 ");
		mDaMaoXian.add("让他到街上大喊“卖拖鞋啦～2块一双，买一送3” ");
		mDaMaoXian.add("抓着铁门喊“放我出去！” ");
	}

	public static ListDataUtils getInstance() {
		return me;
	}
}
