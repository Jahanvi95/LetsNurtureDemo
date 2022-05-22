package com.example.demoapplication.utills

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.hardware.Camera
import android.location.Address
import android.location.Geocoder
import android.media.ExifInterface
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.*
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Base64
import android.util.Log
import android.util.Patterns
import android.view.*
import android.view.animation.AlphaAnimation
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImage
import com.bumptech.glide.request.RequestOptions
import com.example.demoapplication.R
import com.example.demoapplication.utills.AppConstants.DATE_UTILLS.Companion.DATE_dd_MMM
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.type.LatLng
import kotlinx.android.synthetic.main.layout_custom.view.*
import kotlinx.android.synthetic.main.no_network_error_view.view.*
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import java.util.regex.Pattern


/**
 * Show Toast Message
 */
fun Context.toast(msg: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.layoutmanager(): LinearLayoutManager {
    return LinearLayoutManager(
        this,
        RecyclerView.VERTICAL,
        false
    )
}

@Throws(IOException::class)
fun Context.rotateImageIfRequired(img: Bitmap, selectedImage: Uri): Bitmap? {
    val input: InputStream? = this.contentResolver.openInputStream(selectedImage)
    val ei: ExifInterface
    if (Build.VERSION.SDK_INT > 23) ei = ExifInterface(input!!) else ei =
        ExifInterface(selectedImage.path!!)
    val orientation: Int =
        ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
    return when (orientation) {
        ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(img, 90)
        ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(img, 180)
        ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(img, 270)
        else -> img
    }
}

fun getRoatationAngle(mContext: Activity, cameraId: Int): Int {
    val info = Camera.CameraInfo()
    Camera.getCameraInfo(cameraId, info)
    val rotation = mContext.windowManager.defaultDisplay.rotation
    var degrees = 0
    when (rotation) {
        Surface.ROTATION_0 -> degrees = 0
        Surface.ROTATION_90 -> degrees = 90
        Surface.ROTATION_180 -> degrees = 180
        Surface.ROTATION_270 -> degrees = 270
    }
    var result = 0
    result = (result + 45) / 90 * 90
    if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
        result = (info.orientation + degrees) % 360
        result = (360 - result) % 360 // compensate the mirror
    } else { // back-facing
        result = (info.orientation - degrees + 360) % 360
    }
    return result
}



@RequiresApi(Build.VERSION_CODES.O)
fun String.stringToLocalDate(formate: String = DATE_dd_MMM): LocalDate {
    //convert String to LocalDate
    return LocalDate.parse(this, DateTimeFormatter.ofPattern(formate))
}




fun Context.rotateImageIf1Required(img: Bitmap, selectedImage: Uri): Bitmap? {
    loge("rotateImageIfRequired", selectedImage.toString())
    val input: InputStream? =
        this.contentResolver.openInputStream(Uri.parse("file:" + selectedImage.path))
    val ei: ExifInterface
    if (Build.VERSION.SDK_INT > 23) ei = ExifInterface(input!!) else ei =
        ExifInterface(Uri.parse("file:" + selectedImage.path).path!!)
    val orientation: Int =
        ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
    return when (orientation) {
        ExifInterface.ORIENTATION_ROTATE_90 -> rotateImage(img, 90)
        ExifInterface.ORIENTATION_ROTATE_180 -> rotateImage(img, 180)
        ExifInterface.ORIENTATION_ROTATE_270 -> rotateImage(img, 270)
        else -> img
    }
}

fun rotate(bitmap: Bitmap, degree: Int): Bitmap? {
    val w = bitmap.width
    val h = bitmap.height
    val mtx = Matrix()
    mtx.postRotate(degree.toFloat())
    return Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, true)
}

fun Context.openWebUrl(url: String) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    startActivity(i)
}

fun View.fadeIn(durationMillis: Long = 500) {
    this.startAnimation(AlphaAnimation(0F, 1.5F).apply {
        duration = durationMillis
        fillAfter = true
    })
}

fun View.fadeOut(durationMillis: Long = 250) {
    this.startAnimation(AlphaAnimation(1F, 0F).apply {
        duration = durationMillis
        fillAfter = true
    })
}

fun RotateBitmap(source: Bitmap, angle: Float): Bitmap {
    val matrix = Matrix()
    matrix.postRotate(angle)
    return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
}


@SuppressLint("SimpleDateFormat")
fun String.convertStringToDate(format: String): Date {
    val dtStart = this
    val simpleFormat = SimpleDateFormat(format, Locale.ENGLISH)
    return try {
        val date1 = simpleFormat.parse(dtStart)
        date1
    } catch (e: ParseException) {
        e.printStackTrace()
        Date()
    }
}


fun Context.loge(tag: String = "Easy Norway", msg: String) {
    Log.e(tag, msg)
}

fun Context.logd(tag: String = "Easy Norway", msg: String) {
    Log.e(tag, msg)
}

fun View.visibilityGone(isVisible: Boolean = false) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.inVisibilityGone(isVisible: Boolean = false) {
    this.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
}

fun View.navigateFragment(id: Int) {
    Navigation.findNavController(this).navigate(id)
}

fun View.navigateFragmentwithBundle(id: Int,bundle: Bundle) {
    Navigation.findNavController(this).navigate(id,bundle)
}

fun View.backToPreviousFragment(fragment: Fragment) {
    val appBarConfiguration = AppBarConfiguration(findNavController(fragment).graph)
    findNavController(fragment).navigateUp(appBarConfiguration)
}

//fun View.navigateFragmentWithArgs(
//    id: Int, args: Bundle, extras: FragmentNavigator.Extras = FragmentNavigatorExtras(
//        imageView to "imageView1"
//    )
//) {
//    Navigation.findNavController(this).navigate(id, args, null, extras)
//}


fun Fragment.addNavigateWithArgs(id: Int, args: Bundle = Bundle()) {
    findNavController(this).navigate(id, args)
}

fun Context.isShowKeyBoard(isShow: Boolean, view: View) {
    view.apply {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}


fun showKeyboard(context: Context) {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(
        InputMethodManager.SHOW_FORCED,
        InputMethodManager.HIDE_IMPLICIT_ONLY
    )
}

fun AppCompatTextView.spannableBold(
    mainString: String = "",
    startIndex: Int = 0,
    endIndex: Int = mainString.length,
) {

    val txtSpannable = SpannableString(mainString)
    val boldSpan = StyleSpan(Typeface.BOLD)
    txtSpannable.setSpan(boldSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    this.setText(txtSpannable, TextView.BufferType.SPANNABLE)
}

@SuppressLint("ResourceAsColor")
fun AppCompatTextView.spannableColorBold(
    mainString: String = "",
    startIndex: Int = 0,
    endIndex: Int = mainString.length,
    color: Int = R.color.black
) {

    val txtSpannable = SpannableString(mainString)
    // Span to set text color to some RGB value
    val fcs = ForegroundColorSpan(color)

    val boldSpan = StyleSpan(Typeface.BOLD)
    txtSpannable.setSpan(fcs, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

    txtSpannable.setSpan(boldSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    this.text = txtSpannable
}

fun Fragment.addNavigateFragmentWithArgs(id: Int) {
    findNavController(this).navigate(id)
}

fun View.setOnSingleClickListener(clickListener: View.OnClickListener?) {
    clickListener?.also {
        setOnClickListener(OnSingleClickListener(it))
    } ?: setOnClickListener(null)
}

class OnSingleClickListener(
    private val clickListener: View.OnClickListener,
    private val intervalMs: Long = 2000,
) : View.OnClickListener {
    private var canClick = AtomicBoolean(true)

    override fun onClick(v: View?) {
        if (canClick.getAndSet(false)) {
            v?.run {
                postDelayed({
                    canClick.set(true)
                }, intervalMs)
                clickListener.onClick(v)
            }
        }
    }
}


/**
 * Show custom Toast Message
 */
@SuppressLint("RestrictedApi")
@RequiresApi(Build.VERSION_CODES.Q)
fun Context.customToast(
    view: View,
) {
    val marginFromSides = 15
    val height = 120f
    val snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
    val layout = snackbar.view as Snackbar.SnackbarLayout
    val snackView: View = LayoutInflater.from(this).inflate(
        R.layout.layout_network_toast,
        null
    ) // use the parent ViewGroup instead of null
    val imageView = snackView.findViewById(R.id.imgWifi) as ImageView
    val text = snackView.findViewById(R.id.txtNetworkMsg) as TextView
    val bg = snackView.findViewById(R.id.clMain) as ConstraintLayout
    val snackBarView = snackbar.view as Snackbar.SnackbarLayout
    val parentParams = snackBarView.layoutParams as FrameLayout.LayoutParams
    parentParams.setMargins(marginFromSides, 0, marginFromSides, marginFromSides)
    parentParams.height = height.toInt()
    parentParams.width = FrameLayout.LayoutParams.MATCH_PARENT
    snackBarView.layoutParams = parentParams
    // drawable.setColor(getColor(R.color.grey));
    text.text = getString(R.string.no_internet_connection)
    imageView.setImageDrawable(getDrawable(R.drawable.ic_vector_wifi_off))
    layout.setPadding(0, 0, 0, 0) // Add the view to the Snackbar's layout
    layout.addView(snackView, 0)
    snackbar.show()
}


fun View.preventDoubleClick() {
    isClickable = false

}


fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}


fun getColoredSpanned(text: String, color: String): String {
    return "<font color=$color>$text</font>"
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}

/**
 * Save data into SharedPreferences
 */
@SuppressLint("ApplySharedPref")
fun Context.savePreferences(key: String, value: String) {
    try {
        val sharedpreferences =
            this.getSharedPreferences(
                this.resources.getString(R.string.app_name),
                Context.MODE_PRIVATE
            )
        val editor = sharedpreferences!!.edit()
        editor.putString(key, value)
        editor.commit()
        editor.apply()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * get data from SharedPreferences
 */
fun Context.loadPreferences(key: String): String {
    return try {
        val strValue: String?
        val preferences = this.getSharedPreferences(
            this.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        strValue = preferences.getString(key, "")
        strValue!!
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

/**
 * Remove particular one as value from SharedPreferences
 */
fun Context.removePreferences(key: String) {
    try {
        val preferences = this.getSharedPreferences(
            this.resources.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
        val spreferencesEditor = preferences!!.edit()
        spreferencesEditor.remove(key)
        spreferencesEditor.apply()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun AppCompatAutoCompleteTextView.checkMarquee() {
    this.isSelected = true
    this.ellipsize = TextUtils.TruncateAt.MARQUEE
    this.marqueeRepeatLimit = -1
    this.isSingleLine = true
    this.isSelected = true
}


/**
 * To check weather internet is connected or not
 */
fun Context.isConnectedToInternet(): Boolean {
    val connectivity = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivity.activeNetworkInfo
    return if (activeNetwork != null) { // connected to the internet
        if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
            // connected to wifi
            true
        } else activeNetwork.type == ConnectivityManager.TYPE_MOBILE
    } else {
        // not connected to the internet
        false
    }
}

fun Context.getStatusBarHeight(): Int {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) resources.getDimensionPixelSize(resourceId)
    else 0
}

/**
 * For move to new activity through passing intent
 */
inline fun <reified T : Activity> Activity.startActivityF(
    finish: Boolean = false,
    clearTop: Boolean = false,
) {
    val i = Intent(this, T::class.java)
    if (clearTop) {
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    }
    startActivity(i)
    if (finish) {
        this.finish()
    }
}





////this is use for fragment
//inline fun <reified T : Activity>startActivit1(
//    activity: Activity,
//    finish: Boolean = false,
//    clearTop: Boolean = false,
//) {
//    val i = Intent(activity, T::class.java)
//    if (clearTop) {
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//    }
//    startActivity(activity.applicationContext,i ,null)
//    if (finish) {
//        activity.finish()
//    }
//}


fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}


fun ViewGroup.DataBindingInflate(
    @LayoutRes layoutId: Int,
    attachToRoot: Boolean = false,
): ViewDataBinding {
    val layoutInflater = LayoutInflater.from(context)
    val binding =
        DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, this, attachToRoot)
    return binding
}


var dialog: AlertDialog? = null

/***
 * This method is to show custom dialog and handle exception message
 */
fun Context.showDialog(
    cancelable: Boolean = false,
    cancelableTouchOutside: Boolean = false, builderFunction: AlertDialog.Builder.() -> Any,
) {
    try {
        val builder = AlertDialog.Builder(this)
        builder.builderFunction()
        dialog = builder.create()

        dialog!!.setCancelable(cancelable)
        dialog!!.setCanceledOnTouchOutside(cancelableTouchOutside)
        dialog!!.show()
        dialog!!.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK)
        dialog!!.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun AlertDialog.Builder.positiveButton(text: String = "Ok", handleClick: (i: Int) -> Unit = {}) {
    this.setPositiveButton(text) { dialog, i ->
        run {
            handleClick(i)
            dialog.dismiss()
        }
    }
}

fun AlertDialog.Builder.negativeButton(
    text: String = "Cancel",
    handleClick: (i: Int) -> Unit = {},
) {
    this.setNegativeButton(text) { dialog, i ->
        run {
            handleClick(i)
            dialog.dismiss()
        }
    }
}

fun hideDialog() {
    try {
        if (dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


fun RecyclerView.smoothSnapToPosition(
    position: Int,
    snapMode: Int = LinearSmoothScroller.SNAP_TO_START,
) {
    val smoothScroller = object : LinearSmoothScroller(this.context) {
        override fun getVerticalSnapPreference(): Int {
            return snapMode
        }

        override fun getHorizontalSnapPreference(): Int {
            return snapMode
        }
    }
    smoothScroller.targetPosition = position
    layoutManager?.startSmoothScroll(smoothScroller)
}

fun Context.uriToImageFile(uri: Uri): File? {
    val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
    val cursor = contentResolver.query(uri, filePathColumn, null, null, null)
    if (cursor != null) {
        if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val filePath = cursor.getString(columnIndex)
            cursor.close()
            return File(filePath)
        }
        cursor.close()
    }
    return null
}


fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard((if (currentFocus == null) View(this) else currentFocus)!!)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyBoard(edt: EditText) {
    try {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(edt, InputMethodManager.SHOW_IMPLICIT)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@SuppressLint("SimpleDateFormat")
fun AppCompatTextView.checkStringEmpty(data: String) {
    if (data.isNotEmpty()) {
        this.text = data
    } else {
        this.text = this.context.getString(R.string.str_n_a)
    }
}


fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            /*
            * This method will call before text changed
            */
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            /*
            * This method will call on text changed
            */
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}


fun EditText.validEmail1(email: String): Boolean {
    return TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun String.validEmail(email: String, mContext: Context): Boolean {
    var matches = false
    /*if(mContext.customPrefs().isAR()){
        val pattern =
            Pattern.compile("[u0621-u064Au0660-u0669a-zA-Z0-9+._%-+]{1,256}@[u0621-u064Au0660-u0669a-zA-Z0-9][u0621-u064Au0660-u0669a-zA-Z0-9-]{0,64}(.[u0621-u064Au0660-u0669a-zA-Z0-9][u0621-u064Au0660-u0669a-zA-Z0-9-]{0,25})+")
        val matcher = pattern.matcher(this)
        matches = matcher.matches()
    }else{*/
    matches = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    //  }
    return matches
}

fun String.isValidWebsite(web: String): Boolean {
    val pattent1 =
        ""
    return web.matches(Regex(pattent1))
}


//fun String.validPhone(phone: String): Boolean {
//    return android.util.Patterns.PHONE.matcher(phone).matches()
//}

private const val PASSWORD_PATTERN = "[^A-Za-z0-9(?=.*?[#?!@\$%^&*)]"

fun String.isValidPassword(): Boolean {
   // val pattern = Pattern.compile(  "^[a-z0-9A-Z]*\$")
    val pattern = Pattern.compile(  "^[a-z0-9A-Z!@#\$&*~]*\$")
//    val pattern =
//        Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{6,}\$")
    val matcher = pattern.matcher(this)
    return !matcher.matches()

}


//fun String.isValidWebsite(): Boolean {
//    val pattern =
//        Pattern.compile("http[s]?://(([^/:.[:space:]]+(.[^/:.[:space:]]+)*)|([0-9](.[0-9]{3})))(:[0-9]+)?((/[^?#[:space:]]+)([^#[:space:]]+)?(#.+)?)?")
//    val matcher = pattern.matcher(this)
//    return matcher.matches()
//}


fun EditText.validEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}


fun isValidEmail(email: String): Boolean {
    return TextUtils.isEmpty(email) || Patterns.EMAIL_ADDRESS.matcher(email).matches()
}


inline operator fun <reified T> SharedPreferences.get(key: String, defaultValue: T): T {
    when (T::class) {
        Boolean::class -> return this.getBoolean(key, defaultValue as Boolean) as T
        Float::class -> return this.getFloat(key, defaultValue as Float) as T
        Int::class -> return this.getInt(key, defaultValue as Int) as T
        Long::class -> return this.getLong(key, defaultValue as Long) as T
        String::class -> return this.getString(key, defaultValue as String) as T
        else -> {
            if (defaultValue is Set<*>) {
                return this.getStringSet(key, defaultValue as Set<String>) as T
            }
        }
    }

    return defaultValue
}

fun Double.round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()

inline fun <reified T> SharedPreferences.put(key: String, value: T) {
    val editor = this.edit()

    when (T::class) {
        Boolean::class -> editor.putBoolean(key, value as Boolean)
        Float::class -> editor.putFloat(key, value as Float)
        Int::class -> editor.putInt(key, value as Int)
        Long::class -> editor.putLong(key, value as Long)
        String::class -> editor.putString(key, value as String)
        else -> {
            if (value is Set<*>) {
                editor.putStringSet(key, value as Set<String>)
            }
        }
    }

    editor.apply()
}


@SuppressLint("ApplySharedPref", "CommitPrefEdits")
fun SharedPreferences.getEditor(): SharedPreferences.Editor? {
    return try {
        val editor = edit()
        editor.commit()
        editor.apply()
        editor
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}


@SuppressLint("ApplySharedPref")
fun Context.getSharedPref(): SharedPreferences {
    return this.getSharedPreferences(
        this.resources.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )
}


inline fun <T : Fragment> T.withArgs(
    argsBuilder: Bundle.() -> Unit,
): T =
    this.apply {
        arguments = Bundle().apply(argsBuilder)
    }


@SuppressLint("SimpleDateFormat")
fun String.toDate(dateFormat: String): Date {
    if (!this.isNullOrEmpty()) {
        val format = SimpleDateFormat(dateFormat)
        return format.parse(this)
    } else {
        return Date()
    }

}



fun String.getMonth(): String {
    val sdf = SimpleDateFormat("MM")
    return sdf.format(this)
}

fun String.isValidVatNumber(): Boolean {
    return if (TextUtils.isEmpty(this)) {
        false
    } else {
        val regexp = "(BE)?0[0-9]{9}"
        this.matches(regexp.toRegex())
    }
}


fun String.decode(): String {
    return Base64.decode(this, Base64.DEFAULT).toString(charset("UTF-8"))
}

fun tintButton(btn: Button, background: Int, backgroundcolor: Int) {
    var colors = btn.resources.getColorStateList(backgroundcolor)
    var drawble = DrawableCompat.wrap(btn.background)
    DrawableCompat.setTintList(drawble, colors)
    btn.background = drawble
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun Group.setAllOnClickListener(listener: View.OnClickListener?) {
    referencedIds.forEach { id ->
        rootView.findViewById<View>(id).setOnClickListener(listener)
    }


}

internal fun Context.getColorCompat(@ColorRes color: Int) = ContextCompat.getColor(this, color)

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(format: String): String {
    val formatter = SimpleDateFormat(format, Locale("en"))
    val date = Date()
    return formatter.format(date)
}

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()


/**
 * Context is alive or not
 *
 * @return {@link #Boolean}
 */
fun Context?.isAlive(): Boolean {
    this?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activityManager =
                getSystemService(AppCompatActivity.ACTIVITY_SERVICE) as ActivityManager
            val tasksnacks =
                activityManager.appTasks
            for (task in tasksnacks) {
                task.taskInfo.baseActivity?.let {
                    if (packageName.equals(it.packageName, ignoreCase = true))
                        return true
                }
            }
        } else {
            val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val tasks = activityManager.getRunningTasks(Integer.MAX_VALUE)

            for (task in tasks) {
                if (packageName.equals(task.baseActivity!!.packageName, ignoreCase = true))
                    return true
            }
        }
    }
    return false
}


fun Context.getFormattedDate(
    inputFormat: String = "yyyy-MM-dd",
    outputFormat: String,
    inputDate: String,
): String {
    val inputFormat = inputFormat
    var outputFormat = outputFormat
    if (outputFormat == "") {
        outputFormat =
            "EEEE d 'de' MMMM 'del' yyyy" // if inputFormat = "", set a default output format.
    }
    var parsed: Date? = null
    var outputDate = ""
    val dfInput = SimpleDateFormat(inputFormat, Locale.UK)
    val dfOutput = SimpleDateFormat(outputFormat, Locale.UK)
    try {
        parsed = dfInput.parse(inputDate)
        outputDate = dfOutput.format(parsed).replace(".", "")
    } catch (e: Exception) {
        Log.e(
            "formattedDateFromString",
            "Exception in formate Date From string(): " + e.message
        )
        e.printStackTrace()
    }
    return outputDate
}

//Lottie file success link
//https://edit.lottiefiles.com/?src=https%3A%2F%2Fassets9.lottiefiles.com%2Fpackages%2Flf20_rGbZEa.json
fun Context.showNetworkMessageView(
    mClickListener: View.OnClickListener?,
) {
    val dialog = Dialog(this)
    dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
    val dialogLayout = LayoutInflater.from(this).inflate(
        R.layout.no_network_error_view,
        null
    )
    dialog.setCancelable(false)

    dialogLayout.btnRetry1.setOnClickListener {
        dialog.dismiss()
        mClickListener?.onClick(it)
    }
    dialog.window!!.attributes.windowAnimations = R.style.DialogAnimations
    dialog.setContentView(dialogLayout)
    dialog.show()

}


fun Context.showNewCustomMessageView(
    isFrom: String="",
    message: String,
    mClickListener: View.OnClickListener?,
) {
    val dialog = Dialog(this)
    dialog.setCancelable(false)
    dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
    val dialogLayout = LayoutInflater.from(this).inflate(R.layout.layout_custom, null)

    dialog.window!!.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )
    val back = ColorDrawable(Color.TRANSPARENT)
    val inset = InsetDrawable(back, 40)
    dialog.window!!.setBackgroundDrawable(inset)
    if (isFrom.equals(AppConstants.PREFERECENCE_UTILLS.ERROR)) {
        dialogLayout.txtSuccess.text = getString(R.string.str_whoops)
        dialogLayout.txtSuccess.setTextColor(resources.getColor(R.color.black))
        dialogLayout.txtmsg.text = message
        dialogLayout.txtOk.text = getString(R.string.str_try_again)
        dialogLayout.txtOk.setTextColor(resources.getColor(R.color.white))
        // dialogLayout.txtOk.setBackgroundColor(resources.getColor(R.color.colorred))
        dialogLayout.txtOk.setBackgroundDrawable(resources.getDrawable(R.drawable.button_selector_red))
    } else {
        //success json
        //https://edit.lottiefiles.com/?src=https%3A%2F%2Fassets6.lottiefiles.com%2Fpackages%2Flf20_a7kivydz.json
        dialogLayout.txtSuccess.text = getString(R.string.str_wohoo)
        dialogLayout.txtSuccess.setTextColor(resources.getColor(R.color.black))
        dialogLayout.txtmsg.text = message
        dialogLayout.txtOk.setTextColor(resources.getColor(R.color.white))
        dialogLayout.txtOk.setBackgroundDrawable(resources.getDrawable(R.drawable.button_selector))
        // dialogLayout.txtOk.setBackgroundColor(resources.getColor(R.color.color_bg))

    }
    dialogLayout.txtOk.setOnClickListener {
        dialog.dismiss()
        mClickListener?.onClick(it)
    }
    dialog.window!!.attributes.windowAnimations = R.style.DialogAnimations
    dialog.setContentView(dialogLayout)
    dialog.show()

}


fun Activity.showAuthCodeDialog(
    prefs: SharedPreferences,
    message: String,
    mClickListener: View.OnClickListener?,
) {
    val dialog = Dialog(this)
    dialog.setCancelable(false)
    dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
    val dialogLayout = LayoutInflater.from(this).inflate(R.layout.layout_custom, null)
    dialogLayout.txtSuccess.text = getString(R.string.str_whoops)
    dialogLayout.txtSuccess.setTextColor(resources.getColor(R.color.black))
    dialogLayout.txtmsg.text = message

    dialogLayout.txtOk.setOnClickListener {
        dialog.dismiss()
        mClickListener?.onClick(it)
//        startActivityF<LogInActivity>(
//            finish = true,
//            clearTop = true
//        )
    }
    dialog.window!!.attributes.windowAnimations = R.style.DialogAnimations
    dialog.setContentView(dialogLayout)
    dialog.show()

}



/*private fun setLocale(context: Context,locale: Locale) {
    val resources: Resources = context.resources
    val configuration = resources.configuration
    val displayMetrics: DisplayMetrics = resources.displayMetrics
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        configuration.setLocale(locale)
    } else {
        configuration.locale = locale
    }
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
        ApplicationProvider.getApplicationContext<Context>()
            .createConfigurationContext(configuration)
    } else {
        resources.updateConfiguration(configuration, displayMetrics)
    }
}*/


fun AppCompatTextView.setVersion(context: Context) {
    val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
    val version = pInfo.versionName
    this.text = context.getString(R.string.str_version) + " " + version
}

fun ImageView.circularImage(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this).load(url)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_avatar)
//            .diskCacheStrategy(DiskCacheStrategy.NONE )
//            .skipMemoryCache(true)
            .into(this)
    } else {
        Glide.with(this).load(R.drawable.ic_avatar)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_avatar)
            .into(this)
    }

}

fun ImageView.setImage(url: String) {
    Glide.with(this).load(url)
        .placeholder(R.drawable.ic_avatar)
        .into(this)
}

 fun Context.getAddress(latitude: Double, longitude: Double): String {
    val result = StringBuilder()
    try {
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
        if (addresses.size > 0) {
            val address: Address = addresses[0]
            result.append(address.getLocality()).append("\n")
            result.append(address.getCountryName())

        }
    } catch (e: IOException) {
        Log.e("tag", e.message!!)
    }
    return result.toString()
}

fun Context.getLocationFromAddress(strAddress: String?): Address? {
    val coder = Geocoder(this)
    val address: List<Address>?
    var p1: Address? = null
    try {
        // May throw an IOException
        address = coder.getFromLocationName(strAddress, 5)
        if (address == null) {
            return null
        }
        if(address.isNotEmpty()) {
            p1 = address[0]
        }


    } catch (ex: IOException) {
        ex.printStackTrace()
    }
    return p1
}

fun isValidLatLng(lat: Double, lng: Double): Boolean {
    if (lat < -90 || lat > 90) {
        return false
    } else if (lng < -180 || lng > 180) {
        return false
    }
    return true
}


//fun openPdfFile(context: Context, url: String) {
//    val fileExt = MimeTypeMap.getFileExtensionFromUrl(url)
//    if (fileExt == "pdf") {
//        val builder = CustomTabsIntent.Builder()
//        builder.setToolbarColor(
//            ContextCompat.getColor(context, R.color.colorAccent)
//        )
//        builder.addDefaultShareMenuItem()
//        val anotherCustomTab = CustomTabsIntent.Builder().build()
//        val intent = anotherCustomTab.intent
//        intent.data = Uri.parse(url)
//        builder.setShowTitle(true)
//        val customTabsIntent = builder.build()
//        customTabsIntent.intent.setPackage("com.google.android.apps.docs")
//        customTabsIntent.launchUrl(context, Uri.parse(url))
//    } else {
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        intent.setPackage("com.android.chrome")
//        try {
//            context.startActivity(intent)
//        } catch (ex: ActivityNotFoundException) {
//            intent.setPackage(null)
//            context.startActivity(intent)
//        }
//    }
//}


fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInVisible() {
    visibility = View.GONE
}

internal fun TextView.setTextColorRes(@ColorRes color: Int) =
    setTextColor(context.getColorCompat(color))


internal fun Context.getDrawableCompat(@DrawableRes drawable: Int) =
    ContextCompat.getDrawable(this, drawable)

fun String.isValidUrl(): Boolean {
    val URL_REGEX = "^((https?|http?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$"

    val p = Pattern.compile(URL_REGEX)
    val m = p.matcher(this) //replace with string to compare

    return m.matches()

}

fun compareDates(startDate: String, endDate: String): Boolean {
    if (startDate.isNotEmpty() && endDate.isNotEmpty()) {
        val df = SimpleDateFormat(DATE_dd_MMM)
        if (endDate != startDate) {
            val enddate = df.parse(endDate)
            val startDate = df.parse(startDate)
            return enddate.after(startDate)
        }
        return true
    }
    return true
}

fun Context.setAutoLinkForPhoneWorkaround(textView: TextView, phoneText: String) {
    textView.text = phoneText
    textView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
    textView.setOnClickListener {
        val intent = Intent(
            Intent.ACTION_VIEW, Uri.parse(
                "tel:$phoneText"
            )
        )
        startActivity(intent)
    }
}


fun View.isRTL(isRTl: Boolean) {
    if (isRTl) {
        this.layoutDirection = View.LAYOUT_DIRECTION_RTL
    } else {
        this.layoutDirection = View.LAYOUT_DIRECTION_LTR

    }

}

fun TextInputEditText.disableCopyPaste() {
    isLongClickable = false
    setTextIsSelectable(false)
    customSelectionActionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return false
        }

        override fun onDestroyActionMode(mode: ActionMode?) {

        }


    }
}
fun changeLanguage(context: Context) {
    Locale.setDefault(Locale.ENGLISH)
    val config: Configuration = context.resources.configuration
     config.setLocale(Locale.ENGLISH)
    context.createConfigurationContext(config)

}

fun String.base64ToString(): String {
    val data: ByteArray = Base64.decode(this, Base64.DEFAULT)
    return String(data, StandardCharsets.UTF_8)
}


fun isNetworkAvailable(context: Context?): Boolean {
    if (context == null) return false
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
    } else {
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            return true
        }
    }
    return false
}
 fun isNetworkConnected(context: Context): Boolean {
     val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
     val netInfo: NetworkInfo? = cm!!.activeNetworkInfo
     return netInfo != null && netInfo.isConnectedOrConnecting
}
