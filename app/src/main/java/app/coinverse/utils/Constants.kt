package app.coinverse.utils

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig.getInstance

// Firebase
const val RC_SIGN_IN = 123
const val TIMESTAMP = "timestamp"
const val QUALITY_SCORE = "qualityScore"

// Room
const val DATABASE_NAME = "coinverse-db"
val ROOM_MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE content ADD COLUMN loadingStatus INTEGER DEFAULT 0 NOT NULL")
    }
}
val ROOM_MIGRATION_2_3: Migration = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
                "CREATE TABLE content_new (id TEXT DEFAULT '123' NOT NULL, qualityScore REAL DEFAULT 0.0 NOT NULL, contentType INTEGER DEFAULT 0 NOT NULL, timestamp INTEGER DEFAULT 0 NOT NULL, creator TEXT DEFAULT '' NOT NULL, titleRes TEXT DEFAULT '' NOT NULL, previewImage TEXT DEFAULT '' NOT NULL, description TEXT DEFAULT '' NOT NULL, url TEXT DEFAULT '' NOT NULL, textUrl TEXT DEFAULT '' NOT NULL, audioUrl TEXT DEFAULT '' NOT NULL, feedType INTEGER DEFAULT 0 NOT NULL, savedPosition INTEGER DEFAULT 0 NOT NULL, viewCount REAL DEFAULT 0.0 NOT NULL, startCount REAL DEFAULT 0.0 NOT NULL, consumeCount REAL DEFAULT 0.0 NOT NULL, finishCount REAL DEFAULT 0.0 NOT NULL, organizeCount REAL DEFAULT 0.0 NOT NULL, shareCount REAL DEFAULT 0.0 NOT NULL, clearFeedCount REAL DEFAULT 0.0 NOT NULL, dismissCount REAL DEFAULT 0.0 NOT NULL, PRIMARY KEY(id))")
        database.execSQL(
                "INSERT INTO content_new (id, qualityScore, contentType, timestamp, creator, titleRes, previewImage, description, url, textUrl, audioUrl, feedType, savedPosition, viewCount, startCount, consumeCount, finishCount, organizeCount, shareCount, clearFeedCount, dismissCount) SELECT id, qualityScore, contentType, timestamp, creator, titleRes, previewImage, description, url, textUrl, audioUrl, feedType, savedPosition, viewCount, startCount, consumeCount, finishCount, organizeCount, shareCount, clearFeedCount, dismissCount FROM content")
        database.execSQL("DROP TABLE content")
        database.execSQL("ALTER TABLE content_new RENAME TO content")
    }
}

// Home
val ABOUT_LINK = getInstance().getString("about_link")
val SUPPORT_EMAIL = getInstance().getString("support_email")
val SUPPORT_SUBJECT = getInstance().getString("support_subject")
val SUPPORT_BODY = getInstance().getString("support_body")
val SUPPORT_ISSUE = getInstance().getString("support_issue")
val SUPPORT_VERSION = getInstance().getString("support_version")
val SUPPORT_ANDROID_API = getInstance().getString("support_android_api")
val SUPPORT_DEVICE = getInstance().getString("support_device")
val SUPPORT_USER = getInstance().getString("support_user")
val PRIVACY_POLICY_LINK = getInstance().getString("privacy_policy_link")
val SAVED_BOTTOM_SHEET_PEEK_HEIGHT = getInstance().getDouble("saved_bottom_sheet_peek_height").toInt()

const val PRICEGRAPH_FRAGMENT_TAG = "priceGraphFragmentTag"
const val SIGNIN_DIALOG_FRAGMENT_TAG = "signinDialogFragmentTag"
const val APP_BAR_EXPANDED_KEY = "appBarCollapsedKey"
const val SAVED_CONTENT_EXPANDED_KEY = "savedContentExpandedKey"
const val USER_KEY = "userKey"

// User
val DELETE_USER_FUNCTION = getInstance().getString("delete_user_function")
val USER_ID_FUNCTION_PARAM = getInstance().getString("user_id_function_param")
val PATH_FUNCTION_PARAM = getInstance().getString("path_function_param")

const val SIGNIN_TYPE_KEY = "signInTypeKey"

// Content
val CONTENT_REQUEST_NETWORK_ERROR = getInstance().getString("content_request_network_error")
val CONTENT_REQUEST_SWIPE_TO_REFRESH_ERROR = getInstance().getString("content_swipe_to_refresh_network_error")
val CONTENT_LOGGED_IN_REALTIME_ERROR = "Error retrieving logged in, realtime content_en_collection: "
val CONTENT_LOGGED_IN_NON_REALTIME_ERROR = "Error retrieving logged in, non-realtime content_en_collection: "
val CONTENT_LOGGED_OUT_NON_REALTIME_ERROR = "Error retrieving logged out, non-realtime content_en_collection: "
val CONTENT_PLAY_ERROR = getInstance().getString("content_play_error")
val TTS_CHAR_LIMIT_ERROR = getInstance().getString("tts_char_limit_error")
val TTS_CHAR_LIMIT_ERROR_MESSAGE = getInstance().getString("tts_char_limit_error_message")
val CONTENT_LABEL_ERROR = getInstance().getString("content_label_error")
val CONTENT_IMAGE_CORNER_RADIUS = getInstance().getDouble("content_image_corner_radius").toInt()
val CELL_CONTENT_MARGIN = getInstance().getDouble("cell_content_margin").toInt()
val PREFETCH_DISTANCE = getInstance().getDouble("prefetch_distance").toInt()
val SWIPE_CONTENT_Y_MARGIN_DP = getInstance().getDouble("swipe_content_y_margin_dp").toInt()
val PAGE_SIZE = getInstance().getDouble("page_size").toInt()
val CONTENT_DIALOG_PORTRAIT_HEIGHT_DIVISOR = getInstance().getDouble("content_dialog_portrait_height_divisor").toInt()
val CONTENT_DIALOG_LANDSCAPE_WIDTH_DIVISOR = getInstance().getDouble("youtube_landscape_width_divisor")
val CONTENT_DIALOG_LANDSCAPE_HEIGHT_DIVISOR = getInstance().getDouble("content_dialog_landscape_height_divisor")
val CONSUME_THRESHOLD = getInstance().getDouble("consume_threshold")
val FINISH_THRESHOLD = getInstance().getDouble("finish_threshold")
val CONTENT_ID_PARAM = getInstance().getString("content_id_param")
val CONTENT_TITLE_PARAM = getInstance().getString("content_title_param")
val CONTENT_PREVIEW_IMAGE_PARAM = getInstance().getString("content_image_param")
val FILE_PATH_PARAM = getInstance().getString("file_path_param")
val ERROR_PATH_PARAM = getInstance().getString("error_path_param")
val GET_AUDIOCAST_FUNCTION = getInstance().getString("get_audiocast_function")
val CONTENT_SHARE_TYPE = getInstance().getString("content_share_type")
val CONTENT_SHARE_SUBJECT_PREFFIX = getInstance().getString("content_share_subject_prefix")
val SHARED_VIA_COINVERSE = getInstance().getString("shared_via_coinverse")
val CONTENT_SHARE_DIALOG_TITLE = getInstance().getString("content_share_dialog_title")
val AUDIO_URL = getInstance().getString("audio_url")
val AUDIOCAST_SHARE_MESSAGE = getInstance().getString("audiocast_share_message")
val VIDEO_SHARE_MESSAGE = getInstance().getString("video_share_message")
val SOURCE_SHARE_MESSAGE = getInstance().getString("source_share_message")
val SHARE_CONTENT_IMAGE_TYPE = getInstance().getString("share_content_image_type")
val BITMAP_COMPRESSION_QUALITY = getInstance().getDouble("bitmap_compression_quality").toInt()
val AUDIO_URL_TOKEN_REGEX = "&token.+"
val YOUTUBE_ID_REGEX = "yt-\\b"
const val EXOPLAYER_NOTIFICATION_ID = 2052020
const val BUILD_TYPE_PARAM = "buildTypeParam"
const val RIGHT_SWIPE = 8
const val LEFT_SWIPE = 4
const val CONTENT_FEED_FRAGMENT_TAG = "contentFeedFragmentTag"
const val CONTENT_DIALOG_FRAGMENT_TAG = "contentDialogFragmentTag"
const val SAVED_CONTENT_TAG = "savedContentTag"
const val FEED_TYPE_KEY = "feedType"
const val TO_LOAD_VIEWMODEL = "viewModel"
const val CONTENT_SELECTED_ACTION = "contentSelectedAction"
const val CONTENT_TO_PLAY_KEY = "contentToPlayKey"
const val CONTENT_SELECTED_BITMAP_KEY = "bitmapKey"
const val PLAYER_ACTION = "playerAction"
const val PLAYER_KEY = "playerKey"
const val PLAY_OR_PAUSE_PRESSED_KEY = "playOrPausePressedKey"
const val ADAPTER_POSITION_KEY = 122218133
const val FEED_POSITION_KEY = "contentRecyclerViewPosition"
const val OPEN_FROM_NOTIFICATION_ACTION = "openFromNotificationAction"
const val OPEN_CONTENT_FROM_NOTIFICATION_KEY = "openContentFromNotificationKey"

// Analytics

// Views
val AUDIOCAST_VIEW = getInstance().getString("audiocast_view")
val YOUTUBE_VIEW = getInstance().getString("youtube_view")
val PROFILE_VIEW = getInstance().getString("profile_view")
// Events
val VIEW_CONTENT_EVENT = getInstance().getString("view_content_event")
val START_CONTENT_EVENT = getInstance().getString("start_content_event")
val CONSUME_CONTENT_EVENT = getInstance().getString("consume_content_event")
val FINISH_CONTENT_EVENT = getInstance().getString("finish_content_event")
val ORGANIZE_EVENT = getInstance().getString("organize_content_event")
val SHARE_EVENT = getInstance().getString("share_content_event")
val CLEAR_FEED_EVENT = getInstance().getString("clear_feed_event")
val DISMISS_EVENT = getInstance().getString("dismiss_content_event")
// Params
val USER_ID_PARAM = getInstance().getString("user_id_param")
val TIMESTAMP_PARAM = getInstance().getString("timestamp_param")
val CREATOR_PARAM = getInstance().getString("creator_name_param")

// Utils
const val REQUEST_CODE_LOC_PERMISSION = 1909
const val BITMAP_OFFSET = 0

// Ads
val AD_UNIT_ID = getInstance().getString("ad_unit_id")
val MOPUB_KEYWORDS = getInstance().getString("mopub_keywords")