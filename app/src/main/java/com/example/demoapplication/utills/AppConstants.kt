package com.example.demoapplication.utills

import com.example.demoapplication.BuildConfig


object AppConstants {

    var BASE_URL = if (BuildConfig.DEBUG) {
        "https://admin.thefeelgoodmeal.com/api/"
    } else {
       "https://admin.thefeelgoodmeal.com/api/"

    }

    const val Message = "Message"


    interface PREFERECENCE_UTILLS {
        companion object {
            const val DEVICE_TOKEN = "device_token"
            const val IS_LOGIN = "is_login"
            const val IS_WELCOME = "is_welcome"
            const val USER_NAME = "userName"
            const val USER_EMAIL = "userEmail"
            const val LANGUAGE = "language"
            const val ERROR = "error"

        }
    }


    interface STATUS_CODE {
        companion object {
            const val STATUS_CODE = "StatusCode"
            const val STATUS_200 = 200
            const val STATUS_400 = 400
            const val STATUS_401 = 401
            const val STATUS_500 = 500

        }
    }


    interface UTILS {
        companion object
    }



    interface DATE_UTILLS {
        companion object {
            const val DATE_YYYY_MM_DD = "yyyy-MM-dd"
            const val DATE_YYYY_MM_DD_HH_MM_SS = "yyyy-M-dd HH:mm:ss"
            const val DATE_dd_MMM = "dd-MM-yyyy"
            const val DATE_DD_MM_YYYY = "yyyy-MM-dd HH:mm:ss"
            const val HH_MM = "HH:mm"
            const val HH_MM_SS = "HH:mm:ss"
            const val DD_MMM_YYYY = "dd-MM-yyyy"
            const val HH_MM_A_DD_MMM_YYYY = "HH:mma dd-MMM-yyyy"
            const val DATE_dd_MMM_YYYY = "dd/MM/yyyy"
            const val DATE_MM_DD_YYYY = "MM/dd/yyyy"
            const val DATE_DD_MMM_YYYY = "dd-MM-YYYY HH:mm aa"


        }
    }

    interface APICONSTANTS {
        companion object {
            const val SEARCH_RESTURANT = "customer/restaurant/getsearchrestaurant"
        }
    }

}
