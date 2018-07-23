package pe.startapps.cleanarchitecture.utils

import android.os.Build
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
fun FragmentActivity.replaceContentFragment(containerViewId: Int, fragment: Fragment?): Fragment? {
    supportFragmentManager
            ?.beginTransaction()
            ?.replace(containerViewId, fragment)
            ?.commit()
    return fragment
}

fun AppCompatActivity.setStatusBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = color
    }
}