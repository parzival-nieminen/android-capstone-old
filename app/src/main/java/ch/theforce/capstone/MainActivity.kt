package ch.theforce.capstone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import ch.theforce.capstone.utils.BlurHashDecoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var photo = findViewById<ImageView>(R.id.photo)
        val blurHashString = "LSGktJt7W;Rj_Nxaa#WB?cazoLWB"
        var photoBitmap = BlurHashDecoder.decode(blurHashString, 2160, 3240)

        photo.setImageBitmap(photoBitmap)

    }
}