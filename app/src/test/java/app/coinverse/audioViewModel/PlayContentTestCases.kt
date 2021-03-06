package app.coinverse.audioViewModel

import app.coinverse.feedViewModel.PlayContentTest
import app.coinverse.feedViewModel.mockArticleContent
import app.coinverse.feedViewModel.mockDbContentListForDay
import app.coinverse.feedViewModel.mockYouTubeContent
import app.coinverse.utils.*
import app.coinverse.utils.FeedType.MAIN
import app.coinverse.utils.Status.LOADING
import app.coinverse.utils.Timeframe.DAY
import java.util.stream.Stream

fun playContentTestCases() = Stream.of(
        // ARTICLE
        // MAIN
        PlayContentTest(
                isRealtime = false,
                feedType = MAIN,
                timeframe = DAY,
                status = LOADING,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TXT_FILE_PATH,
                mockGetAudiocastError = "",
                mockPreviewImageUrl = "",
                mockPreviewImageByteArray = ByteArray(0)),
        PlayContentTest(
                isRealtime = false,
                feedType = MAIN,
                timeframe = DAY,
                status = Status.SUCCESS,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TXT_FILE_PATH,
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(1)),
        PlayContentTest(
                isRealtime = false,
                feedType = MAIN,
                timeframe = DAY,
                status = Status.ERROR,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TTS_CHAR_LIMIT_ERROR,
                mockGetAudiocastError = MOCK_TTS_CHAR_LIMIT_ERROR_MESSAGE,
                mockPreviewImageUrl = "",
                mockPreviewImageByteArray = ByteArray(0)),
        PlayContentTest(
                isRealtime = false,
                feedType = MAIN,
                timeframe = DAY,
                status = Status.ERROR,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = "",
                mockGetAudiocastError = MOCK_CONTENT_PLAY_ERROR,
                mockPreviewImageUrl = "",
                mockPreviewImageByteArray = ByteArray(0)),
        // SAVED
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.SAVED,
                timeframe = DAY,
                status = LOADING,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TXT_FILE_PATH,
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(1)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.SAVED,
                timeframe = DAY,
                status = Status.SUCCESS,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0, mockFilePath = MOCK_TXT_FILE_PATH,
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(1)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.SAVED,
                timeframe = DAY,
                status = Status.ERROR,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TTS_CHAR_LIMIT_ERROR,
                mockGetAudiocastError = MOCK_TTS_CHAR_LIMIT_ERROR_MESSAGE,
                mockPreviewImageUrl = "",
                mockPreviewImageByteArray = ByteArray(0)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.SAVED,
                timeframe = DAY,
                status = Status.ERROR,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = "",
                mockGetAudiocastError = MOCK_CONTENT_PLAY_ERROR,
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(0)),
        // DISMISSED
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.DISMISSED,
                timeframe = DAY,
                status = LOADING,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TXT_FILE_PATH,
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(1)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.DISMISSED,
                timeframe = DAY,
                status = Status.SUCCESS,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TXT_FILE_PATH,
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(1)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.DISMISSED, timeframe = DAY,
                status = Status.ERROR,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0,
                mockFilePath = MOCK_TTS_CHAR_LIMIT_ERROR,
                mockGetAudiocastError = MOCK_TTS_CHAR_LIMIT_ERROR_MESSAGE,
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(0)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.DISMISSED,
                timeframe = DAY,
                status = Status.ERROR,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockArticleContent,
                mockPosition = 0, mockFilePath = "",
                mockGetAudiocastError = MOCK_CONTENT_PLAY_ERROR,
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(0)),

        // YOUTUBE
        PlayContentTest(
                isRealtime = false,
                feedType = MAIN,
                timeframe = DAY,
                status = Status.SUCCESS,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockYouTubeContent,
                mockPosition = 0,
                mockFilePath = "",
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(0)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.SAVED,
                timeframe = DAY,
                status = Status.SUCCESS,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockYouTubeContent,
                mockPosition = 0,
                mockFilePath = "",
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(0)),
        PlayContentTest(
                isRealtime = false,
                feedType = FeedType.DISMISSED,
                timeframe = DAY,
                status = Status.SUCCESS,
                mockFeedList = mockDbContentListForDay,
                mockContent = mockYouTubeContent,
                mockPosition = 0,
                mockFilePath = "",
                mockGetAudiocastError = "",
                mockPreviewImageUrl = MOCK_PREVIEW_IMAGE,
                mockPreviewImageByteArray = ByteArray(0)))