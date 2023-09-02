package codeware.music;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private double play = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private double n = 0;
	private String songId = "";
	private String Artist = "";
	private String Title = "";
	private String Data = "";
	private String displayName = "";
	private String Duration = "";
	private String Album = "";
	private String image = "";
	private String decodestring = "";
	private String albumArt = "";
	private double m = 0;
	private HashMap<String, Object> mapvar = new HashMap<>();
	private double exist = 0;
	private String name = "";
	private String imgPath = "";
	private double expand = 0;
	private String currentfile = "";
	private double songPosition = 0;
	private double fav = 0;
	private String songFav = "";
	private String folderName = "";
	private String item_ = "";
	private double wh_ = 0;
	private String allSongsJson = "";
	private double length = 0;
	private double r = 0;
	private String value1 = "";
	private String text = "";
	private double color = 0;
	private double filterFav = 0;
	private double seeking = 0;
	private double volumeLevel = 0;
	private String gifPath = "";
	private String roundedPath = "";
	
	private ArrayList<String> songlist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> songmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> art = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> artNew = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> favoriteMap = new ArrayList<>();
	private ArrayList<String> sortlist = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear14;
	private ListView listview1;
	private ProgressBar progressbar1;
	private LinearLayout linear4play;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear6bar;
	private LinearLayout linear3;
	private ProgressBar progressbar2;
	private ImageView imageview1;
	private LinearLayout linear5;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private TextView textview1;
	private TextView textview2;
	private LinearLayout linear6;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private ImageView imageview5;
	private ImageView imageview11;
	private LinearLayout linear12;
	private LinearLayout linear7;
	private TextView textview3;
	private TextView textview4;
	private TextView textview7;
	private TextView textview5;
	private SeekBar seekbar1;
	private TextView textview6;
	private LinearLayout linear8;
	private ImageView imageview6ordrer;
	private ImageView imageview7pre;
	private ImageView imageview8play;
	private ImageView imageview9next;
	private ImageView imageview10fav;
	private TextView textview9;
	private Button button1;
	
	private MediaPlayer mp;
	private TimerTask t;
	private Intent i = new Intent();
	private TimerTask timer;
	private TimerTask playTimer;
	private TimerTask end;
	private TimerTask newtimer;
	private SharedPreferences file;
	private AlertDialog.Builder d;
	private TimerTask vol;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		linear14 = findViewById(R.id.linear14);
		listview1 = findViewById(R.id.listview1);
		progressbar1 = findViewById(R.id.progressbar1);
		linear4play = findViewById(R.id.linear4play);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear6bar = findViewById(R.id.linear6bar);
		linear3 = findViewById(R.id.linear3);
		progressbar2 = findViewById(R.id.progressbar2);
		imageview1 = findViewById(R.id.imageview1);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		linear6 = findViewById(R.id.linear6);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		imageview5 = findViewById(R.id.imageview5);
		imageview11 = findViewById(R.id.imageview11);
		linear12 = findViewById(R.id.linear12);
		linear7 = findViewById(R.id.linear7);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview7 = findViewById(R.id.textview7);
		textview5 = findViewById(R.id.textview5);
		seekbar1 = findViewById(R.id.seekbar1);
		textview6 = findViewById(R.id.textview6);
		linear8 = findViewById(R.id.linear8);
		imageview6ordrer = findViewById(R.id.imageview6ordrer);
		imageview7pre = findViewById(R.id.imageview7pre);
		imageview8play = findViewById(R.id.imageview8play);
		imageview9next = findViewById(R.id.imageview9next);
		imageview10fav = findViewById(R.id.imageview10fav);
		textview9 = findViewById(R.id.textview9);
		button1 = findViewById(R.id.button1);
		file = getSharedPreferences("file", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				_getSong(_position);
				linear6bar.setVisibility(View.VISIBLE);
				if (songPosition == -1) {
					_CreateMedia(_position);
					_MediaStart();
				}
				else {
					if (_position == songPosition) {
						if (mp.isPlaying()) {
							listview1.setVisibility(View.GONE);
							linear4play.setVisibility(View.GONE);
							linear6.setVisibility(View.VISIBLE);
							expand = 1;
						}
						else {
							_MediaStart();
						}
					}
					else {
						if (mp.isPlaying()) {
							_MediaPause();
						}
						mp.reset();
						mp.release();
						_CreateMedia(_position);
						_MediaStart();
					}
				}
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				listview1.setVisibility(View.GONE);
				linear4play.setVisibility(View.GONE);
				linear6.setVisibility(View.VISIBLE);
				expand = 1;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playPre();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
					linear6bar.setVisibility(View.GONE);
				}
				else {
					_MediaStart();
					linear6bar.setVisibility(View.VISIBLE);
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playNext();
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
				final int _progressValue = _param2;
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar _param1) {
				
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar _param2) {
				if (!(songPosition == -1)) {
					mp.seekTo((int)(seekbar1.getProgress()));
				}
			}
		});
		
		imageview6ordrer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (file.getString("order", "").equals("order")) {
					file.edit().putString("order", "repeat").commit();
					imageview6ordrer.setImageResource(R.drawable.exo_controls_repeat_one);
					SketchwareUtil.showMessage(getApplicationContext(), "Repeat current song");
				}
				else {
					if (file.getString("order", "").equals("repeat")) {
						file.edit().putString("order", "shuffle").commit();
						imageview6ordrer.setImageResource(R.drawable.exo_controls_shuffle);
						SketchwareUtil.showMessage(getApplicationContext(), "Shuffle");
					}
					else {
						file.edit().putString("order", "order").commit();
						imageview6ordrer.setImageResource(R.drawable.ic_my_library_music_white);
						SketchwareUtil.showMessage(getApplicationContext(), "Play in order");
					}
				}
			}
		});
		
		imageview7pre.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playPre();
			}
		});
		
		imageview8play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
					linear6bar.setVisibility(View.GONE);
				}
				else {
					_MediaStart();
					linear6bar.setVisibility(View.VISIBLE);
				}
			}
		});
		
		imageview9next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mp.isPlaying()) {
					_MediaPause();
				}
				mp.reset();
				mp.release();
				_playNext();
			}
		});
		
		imageview10fav.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (songmap.get((int)songPosition).containsKey("favorite")) {
					if (songmap.get((int)songPosition).get("favorite").toString().equals("true")) {
						songmap.get((int)songPosition).put("favorite", "false");
					}
					else {
						songmap.get((int)songPosition).put("favorite", "true");
					}
				}
				else {
					songmap.get((int)songPosition).put("favorite", "true");
				}
				allSongsJson = new Gson().toJson(songmap);
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				_isFavourite(songPosition);
				_setFavorite(songPosition);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				openSettings();
			}
		});
	}
	
	private void initializeLogic() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		
		com.google.android.material.appbar.AppBarLayout appBarLayout = (com.google.android.material.appbar.AppBarLayout) _toolbar.getParent(); appBarLayout.setStateListAnimator(null);
		progressbar2.getProgressDrawable().setColorFilter(Color.parseColor("#ffffff"), android.graphics.PorterDuff.Mode.SRC_IN);
		i.setClass(getApplicationContext(), SplashActivity.class);
		startActivity(i);
		textview1.setSingleLine(true);
		textview1.setEllipsize(TextUtils.TruncateAt.END);
		textview2.setSingleLine(true);
		textview2.setEllipsize(TextUtils.TruncateAt.END);
		textview3.setSingleLine(true);
		textview3.setEllipsize(TextUtils.TruncateAt.END);
		textview4.setSingleLine(true);
		textview4.setEllipsize(TextUtils.TruncateAt.END);
		seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		if (!file.getString("favorite", "").equals("")) {
			favoriteMap = new Gson().fromJson(file.getString("favorite", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (file.getString("order", "").equals("")) {
			file.edit().putString("order", "order").commit();
		}
		seeking = 0;
		filterFav = 0;
		item_ = "";
		play = 0;
		n = 0;
		m = 0;
		expand = 0;
		songPosition = 0;
		listview1.setAdapter(new Listview1Adapter(songmap));
		linear6bar.setVisibility(View.GONE);
		progressbar1.setVisibility(View.GONE);
		linear4play.setVisibility(View.VISIBLE);
		linear6.setVisibility(View.GONE);
		
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_create();
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(200));
		sortlist.add("Name");
		sortlist.add("Artist");
		sortlist.add("Favorite");
		sortlist.add("Descending");
	}
	
	@Override
	public void onBackPressed() {
		if (expand == 0) {
			finish();
		}
		else {
			listview1.setVisibility(View.VISIBLE);
			linear6.setVisibility(View.GONE);
			linear4play.setVisibility(View.VISIBLE);
			expand = 0;
		}
	}
	public void _getSong(final double _pos) {
		if (expand == 1) {
			linear4play.setVisibility(View.GONE);
		}
		else {
			linear4play.setVisibility(View.VISIBLE);
		}
		textview1.setText(songmap.get((int)_pos).get("title").toString());
		textview2.setText(songmap.get((int)_pos).get("artist").toString());
		textview3.setText(songmap.get((int)_pos).get("title").toString());
		textview4.setText(songmap.get((int)_pos).get("artist").toString());
		textview7.setText(songmap.get((int)_pos).get("folder").toString());
		currentfile = songmap.get((int)_pos).get("data").toString();
		name = songmap.get((int)_pos).get("artist").toString().toLowerCase();
		m = 0;
		for(int _repeat18 = 0; _repeat18 < (int)(artNew.size()); _repeat18++) {
			if (name.equals(artNew.get((int)m).get("artist").toString().toLowerCase())) {
				if (artNew.get((int)m).containsKey("albumArt")) {
					
					imgPath = artNew.get((int)m).get("albumArt").toString();
					roundedPath = FileUtil.getPackageDataDir(getApplicationContext()).concat("/art/".concat(Uri.parse(imgPath).getLastPathSegment()));
					FileUtil.deleteFile(roundedPath);
					FileUtil.resizeBitmapFileWithRoundedBorder(imgPath, roundedPath, 360);
					Glide.with(getApplicationContext())
					        .load(roundedPath)
					        .into(imageview1);
					imageview5.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(artNew.get((int)m).get("albumArt").toString(), 1024, 1024));
					imageview11.setVisibility(View.GONE);
					imageview5.setVisibility(View.VISIBLE);
				}
				else {
					imageview1.setImageResource(R.drawable.ic_music_blue);
					imageview5.setImageResource(R.drawable.ic_recm_default_exclusive_bg);
					imageview11.setVisibility(View.VISIBLE);
					imageview5.setVisibility(View.GONE);
				}
				break;
			}
			else {
				imageview1.setImageResource(R.drawable.ic_music_blue);
				imageview5.setImageResource(R.drawable.ic_recm_default_exclusive_bg);
				imageview11.setVisibility(View.VISIBLE);
				imageview5.setVisibility(View.GONE);
			}
			m++;
		}
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						bitmap = ((android.graphics.drawable.BitmapDrawable) imageview5.getDrawable()).getBitmap();
						color = getDominantColor1(bitmap);
						if (getSupportActionBar() != null) {
							    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
							    getSupportActionBar().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(manipulateColor(getDominantColor1(bitmap), 0.32f)));
							
							getWindow().setStatusBarColor(manipulateColor(getDominantColor1(bitmap), 0.32f));
						}
						linear1.setBackgroundColor(manipulateColor(getDominantColor1(bitmap), 0.32f));
						linear4play.setBackgroundColor(manipulateColor(getDominantColor1(bitmap), 0.50f));
					}
				});
			}
		};
		_timer.schedule(t, (int)(100));
	}
	
	
	public void _Library() {
	}
	private Bitmap bitmap;
	{
	}
	private void openSettings() {
		    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		    Uri uri = Uri.fromParts("package", getPackageName(), null);
		    intent.setData(uri);
		    startActivityForResult(intent, 101);
	}
	{
	}
	AudioManager audioManager;
	{
	}
	
	
	public void _extra() {
	}
	public static int manipulateColor(int color, float factor) {
		    int a = Color.alpha(color);
		    int r = Math.round(Color.red(color) * factor);
		    int g = Math.round(Color.green(color) * factor);
		    int b = Math.round(Color.blue(color) * factor);
		    return Color.argb(a,
		            Math.min(r, 255),
		            Math.min(g, 255),
		            Math.min(b, 255));
	}
	{
	}
	public static int getDominantColor1(Bitmap bitmap) {
		 try{
			    Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
			    final int color = newBitmap.getPixel(0, 0);
			    newBitmap.recycle();
			    return color;
		}catch (Exception e){
			return -11508009;
		}
	}
	{
	}
	
	
	public void _getAllSong() {
		String selection = android.provider.MediaStore.Audio.Media.IS_MUSIC + " != 0";
		
		String[] projection = {
			    android.provider.MediaStore.Audio.Media._ID,
			    android.provider.MediaStore.Audio.Media.ARTIST,
			    android.provider.MediaStore.Audio.Media.TITLE,
			    android.provider.MediaStore.Audio.Media.DATA,
			    android.provider.MediaStore.Audio.Media.DISPLAY_NAME,
			    android.provider.MediaStore.Audio.Media.DURATION
			
		};
		
		android.database.Cursor cursor = this.managedQuery(
		    android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,projection,selection,null,null);
		
		while(cursor.moveToNext()) {
			     songId = cursor.getString(0);
			     Artist = cursor.getString(1);
			     Title = cursor.getString(2);
			     Data = cursor.getString(3);
			     displayName = cursor.getString(4);
			     Duration = cursor.getString(5);
			
			map = new HashMap<>();
			map.put("id", songId);
			map.put("artist", Artist);
			map.put("title", Title);
			map.put("data", Data);
			map.put("displayName", displayName);
			map.put("duration", Duration);
			java.io.File file = new java.io.File(Data); 
			folderName = file.getParentFile().getName();
			map.put("folder", folderName);
			map.put("playing", "false");
			fav = 0;
			for(int _repeat27 = 0; _repeat27 < (int)(favoriteMap.size()); _repeat27++) {
				if (songId.equals(favoriteMap.get((int)fav).get("id").toString())) {
					map.put("favorite", "true");
				}
				fav++;
			}
			songmap.add(map);
		}
	}
	
	
	public void _getArts() {
		String[] projection1 = {
			    android.provider.MediaStore.Audio.Albums.ARTIST,
			    android.provider.MediaStore.Audio.Albums.ALBUM,
			    android.provider.MediaStore.Audio.Albums.ALBUM_ART
			
		};
		
		final Uri uri = android.provider.MediaStore.Audio.Albums.EXTERNAL_CONTENT_URI;
		
		 android.database.Cursor cursor1 = getContentResolver().query(uri, projection1, null, null, null);
		
		while (cursor1.moveToNext()) {
			Artist = cursor1.getString(0);
			Album = cursor1.getString(1);
			albumArt = cursor1.getString(2);
			mapvar = new HashMap<>();
			mapvar.put("artist", Artist);
			mapvar.put("album", Album);
			mapvar.put("albumArt", albumArt);
			art.add(mapvar);
		}
		artNew = new Gson().fromJson(new Gson().toJson(art), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
	}
	
	
	public void _create() {
		if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
			linear1.setVisibility(View.GONE);
			linear14.setVisibility(View.VISIBLE);
		}else{
			timer.cancel();
			_getAllSong();
			_getArts();
			allSongsJson = new Gson().toJson(songmap);
			_SortMap(songmap, "title", false, true);
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			linear1.setVisibility(View.VISIBLE);
			linear14.setVisibility(View.GONE);
			_getSong(0);
			_CreateMedia(0);
			songmap.get((int)0).put("playing", "true");
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	
	public void _CreateMedia(final double _pos) {
		currentfile = songmap.get((int)_pos).get("data").toString();
		songmap.get((int)songPosition).put("playing", "false");
		songPosition = _pos;
		songmap.get((int)songPosition).put("playing", "true");
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		mp = MediaPlayer.create(getApplicationContext(), Uri.fromFile(new java.io.File(currentfile)));
		progressbar2.setMax((int)mp.getDuration());
		seekbar1.setMax((int)mp.getDuration());
		int dur = (int) mp.getDuration();
		
		int mns = (dur / 60000) % 60000;
		int scs = dur % 60000 / 1000;
		
		NumberFormat formatter = new DecimalFormat("00");
		String seconds = formatter.format(scs);
		
		String songTime = String.format("%02d:%02d", mns,  scs);
		textview6.setText(songTime);
		_isFavourite(_pos);
	}
	
	
	public void _MediaStart() {
		mp.start();
		imageview3.setImageResource(R.drawable.exo_controls_pause);
		imageview8play.setImageResource(R.drawable.exo_controls_pause);
		playTimer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						try{
							progressbar2.setProgress((int)mp.getCurrentPosition());
							seekbar1.setProgress((int)mp.getCurrentPosition());
							int dur = (int) mp.getCurrentPosition();
							
							int mns = (dur / 60000) % 60000;
							int scs = dur % 60000 / 1000;
							
							NumberFormat formatter = new DecimalFormat("00");
							String seconds = formatter.format(scs);
							
							String currentTime = String.format("%02d:%02d", mns,  scs);
							textview5.setText(currentTime);
						}catch(Exception e){
							playTimer.cancel();
							SketchwareUtil.showMessage(getApplicationContext(), "Action failed");
							i.setClass(getApplicationContext(), MainActivity.class);
							startActivity(i);
							finish();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(playTimer, (int)(400), (int)(400));
		mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			                    @Override
			                    public void onCompletion(MediaPlayer mediaPlayer) {
				_songEnd();
			}
			                });
	}
	
	
	public void _MediaPause() {
		playTimer.cancel();
		mp.pause();
		imageview3.setImageResource(R.drawable.exo_controls_play);
		imageview8play.setImageResource(R.drawable.exo_controls_play);
	}
	
	
	public void _playNext() {
		if (songPosition == songmap.size()) {
			_getSong(0);
			_CreateMedia(0);
			_MediaStart();
		}
		else {
			_getSong(songPosition + 1);
			_CreateMedia(songPosition + 1);
			_MediaStart();
		}
	}
	
	
	public void _playPre() {
		if (songPosition == 0) {
			_getSong(songmap.size() - 1);
			_CreateMedia(songmap.size() - 1);
			_MediaStart();
		}
		else {
			_getSong(songPosition - 1);
			_CreateMedia(songPosition - 1);
			_MediaStart();
		}
	}
	
	
	public void _favorite() {
		
	}
	
	
	public void _songEnd() {
		if (file.getString("order", "").equals("order")) {
			if (songPosition == (songmap.size() - 1)) {
				_getSong(0);
				_CreateMedia(0);
				_MediaStart();
			}
			else {
				_getSong(songPosition + 1);
				_CreateMedia(songPosition + 1);
				_MediaStart();
			}
		}
		else {
			
		}
	}
	
	
	public void _isFavourite(final double _pos) {
		if (songmap.get((int)_pos).containsKey("favorite")) {
			if (songmap.get((int)_pos).get("favorite").toString().equals("true")) {
				imageview10fav.setImageResource(R.drawable.ic_heart_fill);
			}
			else {
				imageview10fav.setImageResource(R.drawable.ic_heart_empty);
			}
		}
		else {
			imageview10fav.setImageResource(R.drawable.ic_heart_empty);
		}
	}
	
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					}
					else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				}
				else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					}
					else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
	}
	
	
	public void _setFavorite(final double _pos) {
		fav = 0;
		if (!(favoriteMap.size() == 0)) {
			for(int _repeat10 = 0; _repeat10 < (int)(favoriteMap.size()); _repeat10++) {
				if (favoriteMap.get((int)fav).get("id").toString().equals(songmap.get((int)_pos).get("id").toString())) {
					songFav = "true";
					break;
				}
				else {
					songFav = "false";
				}
				fav++;
			}
		}
		else {
			songFav = "false";
		}
		if (songFav.equals("false")) {
			mapvar = songmap.get((int)_pos);
			favoriteMap.add(mapvar);
		}
		else {
			favoriteMap.remove((int)(fav));
		}
		file.edit().putString("favorite", new Gson().toJson(favoriteMap)).commit();
	}
	
	
	public void _option_menu() {
	}
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		menu.add(0,0,0, "Favorite").setIcon(R.drawable.ic_filter_list_white).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		menu.add(0,1,1, "Favorite").setIcon(R.drawable.ic_refresh).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return true;
	}
	 @Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case 0:
			_move1();
			break;
			case 1:
			_move2();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void _move1() {
		d.setTitle("Sort by");
		_Single_Choice_Dialog(d, sortlist);
		d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				try{
					if (!item_.equals("")) {
						if (!allSongsJson.equals("")) {
							songmap = new Gson().fromJson(allSongsJson, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							if (item_.equals("Name")) {
								_SortMap(songmap, "title", false, true);
								filterFav = 0;
							}
							else {
								if (item_.equals("Artist")) {
									_SortMap(songmap, "artist", false, true);
									filterFav = 0;
								}
								else {
									if (item_.equals("Descending")) {
										_SortMap(songmap, "title", false, false);
										filterFav = 0;
									}
									else {
										if (filterFav == 0) {
											
										}
									}
								}
							}
							if (songmap.size() == 0) {
								SketchwareUtil.showMessage(getApplicationContext(), "Empty list");
								if (!mp.isPlaying()) {
									linear4play.setVisibility(View.GONE);
								}
							}
							listview1.setAdapter(new Listview1Adapter(songmap));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Empty list");
						}
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Select an option");
					}
				} catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), "Action failed");
					finishAffinity();
				}
			}
		});
		d.create().show();
	}
	
	
	public void _Single_Choice_Dialog(final AlertDialog.Builder _dialog, final ArrayList<String> _list) {
		final CharSequence[] _items = _list.toArray(new String[_list.size()]);
		_dialog.setSingleChoiceItems(_items, -1, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				wh_ = which;
				item_ = _list.get((int)(wh_));
				
			}});
	}
	
	
	public void _move2() {
		if (androidx.core.content.ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == android.content.pm.PackageManager.PERMISSION_DENIED) {
			SketchwareUtil.showMessage(getApplicationContext(), "Please allow storage permission");
		}else{
			songmap.clear();
			_getAllSong();
			allSongsJson = new Gson().toJson(songmap);
			_SortMap(songmap, "title", false, true);
			listview1.setAdapter(new Listview1Adapter(songmap));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.cust, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			textview1.setText(songmap.get((int)_position).get("title").toString());
			textview2.setText(songmap.get((int)_position).get("artist").toString().concat(" - ".concat(songmap.get((int)_position).get("folder").toString())));
			gifPath = "file:///android_asset/beats.gif";
			Glide.with(getApplicationContext()).load(gifPath).into(imageview3);
			textview2.setTextColor(0x99000000);
			imageview2.setVisibility(View.VISIBLE);
			textview1.setSingleLine(true);
			textview1.setEllipsize(TextUtils.TruncateAt.END);
			textview2.setSingleLine(true);
			textview2.setEllipsize(TextUtils.TruncateAt.MIDDLE);
			if (songmap.get((int)_position).containsKey("favorite")) {
				if (songmap.get((int)_position).get("favorite").toString().equals("true")) {
					imageview2.setImageResource(R.drawable.ic_heart_fill);
				}
				else {
					imageview2.setImageResource(R.drawable.ic_heart_empty);
				}
			}
			else {
				imageview2.setImageResource(R.drawable.ic_heart_empty);
			}
			if (songmap.get((int)_position).get("playing").toString().equals("true")) {
				textview1.setTextColor(0xFFE91E63);
				imageview3.setVisibility(View.VISIBLE);
			}
			else {
				textview1.setTextColor(0xFF000000);
				imageview3.setVisibility(View.GONE);
			}
			
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}