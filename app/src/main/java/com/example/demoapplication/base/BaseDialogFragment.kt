package com.example.demoapplication.base

import android.app.Dialog
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.demoapplication.R
import com.example.demoapplication.utills.setOnSingleClickListener
import com.example.demoapplication.utills.visibilityGone
import com.glowdubai_staff.base.PreferenceHelper.customPrefs
import com.glowdubai_staff.service.NetworkViewModel
import com.glowdubai_staff.service.ProgressUtils


abstract class BaseDialogFragment<Binding : ViewDataBinding/*,ViewModel : BaseViewModel*/> :
    DialogFragment() /*, EasyPermissions.PermissionCallbacks*/{
    protected lateinit var bindingObject: Binding
    private var sentToSettings = false
    lateinit var prefs: SharedPreferences
    var mProgressUtil: ProgressUtils? = null



    private val networkViewModel: NetworkViewModel by lazy {
        ViewModelProvider(this)[NetworkViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()
        val d: Dialog? = dialog
        if (d != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog!!.setCancelable(false)
            d.window!!.setLayout(width, height)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        bindingObject = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        prefs = requireActivity().customPrefs()
        initView()

        return bindingObject.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initProgress()
        setStyle(
            STYLE_NO_FRAME,
            R.style.FullScreenDialogStyle
        )
        initView()
        listenNetworkState()
        networkViewModel.enableNetworkListener(activity)
    }

    protected abstract fun initView()




    private fun initProgress() {
        if (mProgressUtil == null)
            mProgressUtil = ProgressUtils(lifecycle, requireContext())
    }

    fun showProgress(
        isCancelable: Boolean = false,
        message: String = "",
        mainMessage: String = "",
    ) {
        requireActivity().runOnUiThread {
            initProgress()
            mProgressUtil?.show(isCancelable, message, mainMessage)
        }
    }

    fun hideProgress() {
        requireActivity().runOnUiThread {
            initProgress()
            mProgressUtil?.hide()
        }
    }





    private fun listenNetworkState() {
        networkViewModel.networkLiveData.observe(requireActivity(),
            { t ->
                Log.d("BaseACtivity", "onChanged: network state changed $t")
                if (!t!!) {
                    if (isAdded)
                        onNetWorkChange(t)
                }
            })
    }
    open fun initToolbar(
        textName: AppCompatTextView = bindingObject.root.findViewById(R.id.txtTitlet),
        name: String = "",
        isImgBack: Boolean = false,
        imageBack: AppCompatImageView? = bindingObject.root.findViewById(R.id.imgBack),
        isProfile: Boolean = true,
        ImgProfile: AppCompatImageView? = bindingObject.root.findViewById(R.id.imgProfile),
        isSearch: Boolean = false,
        ImgSearch: AppCompatImageView? = bindingObject.root.findViewById(R.id.imgSearch),
        imageDrawbleSettings: Int = R.drawable.ic_search,
    ) {

        textName.text = name
        imageBack?.visibilityGone(isImgBack)
       /* ImgProfile?.circularImage(
            prefs.getString(AppConstants.PREFERECENCE_UTILLS.PROFILEIMAGE, "").toString()
        )*/
        ImgProfile?.visibilityGone(isProfile)
        ImgSearch?.visibilityGone(isSearch)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        imageBack!!.setOnSingleClickListener {
            findNavController().navigateUp(appBarConfiguration)
        }


    }

    /**
     * on network change this method will call
     */
    abstract fun onNetWorkChange(onNetworkChange: Boolean)
    abstract fun setListner()

    /**
     * Get layout resource id which inflate in onCreateView.
     */
    @LayoutRes
    abstract fun getLayoutResId(): Int

//    protected abstract fun initView()
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String?>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
//    }
//
//    override fun onPermissionsGranted(requestCode: Int, perms: List<String?>) {
//        // Toast.makeText(requireContext(), "Opening camera", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPermissionsDenied(requestCode: Int, perms: List<String?>) {
//        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
////            AppSettingsDialog.Builder(this).setTitle(getString(R.string.str_permission_req))
////                .setRationale(getString(R.string.str_permission_req_title)).build().show()
//            //Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
//
//
//            val dialog = Dialog(requireContext())
//            dialog.setCancelable(false)
//
//            dialog.window!!.decorView.setBackgroundResource(android.R.color.transparent)
//            val dialogLayout =
//                LayoutInflater.from(requireContext()).inflate(R.layout.dialog_logout, null)
//            dialog.window!!.setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//            dialog.window!!.setGravity(Gravity.CENTER)
//            val back = ColorDrawable(Color.TRANSPARENT)
//            val inset = InsetDrawable(back, 40)
//            dialog.window!!.setBackgroundDrawable(inset)
//            dialogLayout.imgLogout.setImageDrawable(requireContext().getDrawable(R.drawable.ic_permission_allow))
//            dialogLayout.txtYes.text = getString(R.string.str_okay)
//            dialogLayout.txtLogout.text = getString(R.string.str_permission_req_title)
//            dialogLayout.txtNo.text = getString(R.string.str_cancle)
//            dialogLayout.txtYes.setOnClickListener {
//                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                    .setData(Uri.fromParts("package", requireContext().packageName, null))
//                startActivity(intent)
//                dialog.dismiss()
//            }
//            dialogLayout.txtNo.setOnClickListener {
//                dialog.dismiss()
//            }
//            dialog.window!!.attributes.windowAnimations = R.style.DialogAnimations
//            dialog.setContentView(dialogLayout)
//            dialog.show()
//
//        }
//    }
//
//
//    @AfterPermissionGranted(123)
//    fun checkCamerapermission() :Boolean {
//        val perms = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        if (EasyPermissions.hasPermissions(requireContext(), *perms)) {
//            return true
//        } else {
//            EasyPermissions.requestPermissions(
//                this, getString(R.string.str_permission_camera), 123, *perms
//            )
//        }
//        return false
//    }

}