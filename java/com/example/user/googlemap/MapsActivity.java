package com.example.user.googlemap;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //이전 우리 kakao앱에서 addr값만 뽑아서 이곳으로 던져주었다고 가정한다.
        //String addr = getIntent().getStringExtra("addr");
        //원래는 Geocoding(지오코딩)으로 주소를 위도-경도 값으로 변환해야 한다.(Open API - 유료인듯?)
        //위경도 볼 수 있는 사이트 - http://mygeoposition.com/
        //아래값은 종로3가역 1호선 위경도 값이다.
        double lat = 40.065070;  //위도 latitude
        double lng = -82.505630;  //경도 longitude

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        LatLng jongno = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(jongno).title("종로3가역"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(jongno, 16));  //한국은 한국코드 16같은게 필요한건가

    }
}
