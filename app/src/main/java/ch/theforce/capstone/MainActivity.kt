package ch.theforce.capstone

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import ch.theforce.capstone.databinding.ActivityMainBinding
import ch.theforce.capstone.network.UnSplashHttpClient
import ch.theforce.capstone.utils.BlurHashDecoder
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var navController: NavController
    private val client: UnSplashHttpClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(activityMainBinding.mainToolbar)

        lifecycleScope.launch() {
            val randomPhoto = client.getRandomPhoto()
            val photoBitmap =
                BlurHashDecoder.decode(
                    randomPhoto.blur_hash,
                    randomPhoto.width / 3,
                    randomPhoto.height / 3
                )
            activityMainBinding.photo.setImageBitmap(photoBitmap)
            Picasso.get().load(randomPhoto.urls.full).into(activityMainBinding.photo)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
