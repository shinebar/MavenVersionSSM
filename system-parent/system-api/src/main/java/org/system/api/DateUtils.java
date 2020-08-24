/**
 * 日期工具类
 * 
 */
public class DateUtils {

	private static final Log logger = LogFactory.getLog(DateUtils.class);


	public static final String DATE_SHORT_FORMAT = "yyyyMMdd";
	public static final String DATE_CH_FORMAT = "yyyy年MM月dd日";
	
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm:ss";

	public static final String DAYTIME_START = "00:00:00";
	public static final String DAYTIME_END = "23:59:59";

	private DateUtils() {
	}

	private static final String[] FORMATS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:ss", "HH:mm",
			"HH:mm:ss", "yyyy-MM", "yyyy-MM-dd HH:mm:ss.S" };

	public static Date convert(String str) {
		if (str != null && str.length() > 0) {
			if (str.length() > 10 && str.charAt(10) == 'T') {
				str = str.replace('T', ' '); // 去掉json-lib加的T字母
			}
			for (String format : FORMATS) {
				if (str.length() == format.length()) {
					try {
						Date date = new SimpleDateFormat(format).parse(str);

						return date;
					} catch (ParseException e) {
						if (logger.isWarnEnabled()) {
							logger.warn(e.getMessage());
						}
						// logger.warn(e.getMessage());
					}
				}
			}
		}
		return null;
	}

	public static Date convert(String str, String format) {
		if (!StringUtils.isEmpty(str)) {
			try {
				Date date = new SimpleDateFormat(format).parse(str);
				return date;
			} catch (ParseException e) {
				if (logger.isWarnEnabled()) {
					logger.warn(e.getMessage());
				}
			}
		}
		return null;
	}

	/**
	 * 时间拼接 将日期和实现拼接 ymd 如2018-04-15 hm 如0812
	 * 
	 * @author 306566 chengjing
	 * @date 2018-04-22 下午4:48:43
	 */
	public static Date concat(String ymd, String hm) {
		if (StringUtils.isNotBlank(ymd) && StringUtils.isNotBlank(hm)) {
			try {
				String dateString = ymd.concat(" ").concat(
						hm.substring(0, 2).concat(":").concat(hm.substring(2, 4)).concat(":00"));
				Date date = DateUtils.convert(dateString, DateUtils.DATE_TIME_FORMAT);
				return date;
			} catch (NullPointerException e) {
				if (logger.isWarnEnabled()) {
					logger.warn(e.getMessage());
				}
			}
		}
		return null;
	}

	/**
	 * 根据传入的日期返回年月日的6位字符串，例：20181203
	 * 
	 * @author 306566 chengjing
	 * @date 2018-04-22 下午4:48:43
	 */
	public static String getDay(Date date) {
		return convert(date, DATE_SHORT_FORMAT);
	}

	/**
	 * 根据传入的日期返回中文年月日字符串，例：2010年12月03日
	 * 
	 * @author 306566 chengjing
	 * @date 2018-04-22 下午4:48:43
	 */
	public static String getChDate(Date date) {
		return convert(date, DATE_CH_FORMAT);
	}
	
        /**
         * 将传入的时间格式的字符串转成时间对象
         * 
         * 例：传入2012-12-03 23:21:24
         * 
	 * @author 306566 chengjing
	 * @date 2018-04-22 下午4:48:43
         */
        public static Date strToDate(String dateStr) {
        	SimpleDateFormat formatDate = new SimpleDateFormat(DATE_TIME_FORMAT);
        	Date date=null;
        	try{
        	    date = formatDate.parse(dateStr);
        	}catch(Exception e){
        	    
        	}
        	return date;
        }
	
	public static String convert(Date date) {
		return convert(date, DATE_TIME_FORMAT);
	}

	public static String convert(Date date, String dateFormat) {
		if (date == null) {
			return null;
		}

		if (null == dateFormat) {
			dateFormat = DATE_TIME_FORMAT;
		}

		return new SimpleDateFormat(dateFormat).format(date);
	}

	/**
	 * 返回该天从00:00:00开始的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDatetime(Date date) {
		String thisdate = convert(date, DATE_FORMAT);
		return convert(thisdate + " " + DAYTIME_START);

	}

	/**
	 * 返回n天后从00:00:00开始的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDatetime(Date date, Integer diffDays) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		String thisdate = df.format(date.getTime() + 1000l * 24 * 60 * 60 * diffDays);
		return convert(thisdate + " " + DAYTIME_START);
	}

	/**
	 * 返回该天到23:59:59结束的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDatetime(Date date) {
		String thisdate = convert(date, DATE_FORMAT);
		return convert(thisdate + " " + DAYTIME_END);

	}

	/**
	 * 返回n天到23:59:59结束的日期
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndDatetime(Date date, Integer diffDays) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		String thisdate = df.format(date.getTime() + 1000l * 24 * 60 * 60 * diffDays);
		return convert(thisdate + " " + DAYTIME_END);

	}

	/**
	 * 返回该日期的最后一刻，精确到纳秒
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getLastEndDatetime(Date endTime) {
		Timestamp ts = new Timestamp(endTime.getTime());
		ts.setNanos(999999999);
		return ts;
	}

	/**
	 * 返回该日期加1秒
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getEndTimeAdd(Date endTime) {
		Timestamp ts = new Timestamp(endTime.getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.add(Calendar.MILLISECOND, 1000);
		c.set(Calendar.MILLISECOND, 0);
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回该日期加 millisecond 毫秒，正数为加，负数为减
	 * @param date
	 * @param millisecond
	 * @return
	 */
	public static Timestamp getDateAdd(Date date, int millisecond) {
		Timestamp ts = new Timestamp(date.getTime());
		Calendar c = Calendar.getInstance();
		c.setTime(ts);
		c.add(Calendar.MILLISECOND, millisecond);
		c.set(Calendar.MILLISECOND, 0);
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 相对当前日期，增加或减少天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static String addDay(Date date, int day) {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);

		return df.format(new Date(date.getTime() + 1000l * 24 * 60 * 60 * day));
	}

	/**
	 * 相对当前日期，增加或减少天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDayToDate(Date date, int day) {
		return new Date(date.getTime() + 1000l * 24 * 60 * 60 * day);
	}

	/**
	 * 返回两个时间的相差天数
	 * 
	 * @param startTime
	 *            对比的开始时间
	 * @param endTime
	 *            对比的结束时间
	 * @return 相差天数
	 */

	public static Long getTimeDiff(String startTime, String endTime) {
		Long days = null;
		Date startDate = null;
		Date endDate = null;
		try {
			if (startTime.length() == 10 && endTime.length() == 10) {
				startDate = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
				endDate = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
			} else {
				startDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(startTime);
				endDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(endTime);
			}

			days = getTimeDiff(startDate, endDate);
		} catch (ParseException e) {
			if (logger.isWarnEnabled()) {
				logger.warn(e.getMessage());
			}
			days = null;
		}
		return days;
	}

	/**
	 * 返回两个时间的相差天数
	 * 
	 * @param startTime
	 *            对比的开始时间
	 * @param endTime
	 *            对比的结束时间
	 * @return 相差天数
	 */
	public static Long getTimeDiff(Date startTime, Date endTime) {
		Long days = null;

		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		long l_s = c.getTimeInMillis();
		c.setTime(endTime);
		long l_e = c.getTimeInMillis();
		days = (l_e - l_s) / 86400000;
		return days;
	}
	
	/**
	 * 返回两个时间的相差分钟数
	 * 
	 * @param startTime
	 *            对比的开始时间
	 * @param endTime
	 *            对比的结束时间
	 * @return 相差分钟数
	 */
	public static Long getMinuteDiff(Date startTime, Date endTime) {
		Long minutes = null;

		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		long l_s = c.getTimeInMillis();
		c.setTime(endTime);
		long l_e = c.getTimeInMillis();
		minutes = (l_e - l_s) / (1000l * 60);
		return minutes;
	}
	
	/**
	 * 返回两个时间的相差秒数
	 * 
	 * @param startTime
	 *            对比的开始时间
	 * @param endTime
	 *            对比的结束时间
	 * @return 相差秒数
	 */
	public static Long getSecondDiff(Date startTime, Date endTime) {

		return (endTime.getTime() - startTime.getTime()) / 1000;
	}

	public static String getPidFromDate(Date date) {
		if (date == null) {
			return "";
		}

		String m = convert(date, "yyyyMM");
		String d = convert(date, "dd");

		if (Integer.valueOf(d) <= 10) {
			d = "01";
		} else if (Integer.valueOf(d) <= 20) {
			d = "02";
		} else {
			d = "03";
		}

		return m.concat(d);
	}
	
	/**
	 * 把java日期转换为XML格式日期
	 * @创建时间 2014-4-12 下午7:44:38   
	 * @创建人： WangQianJin
	 */
	public static XMLGregorianCalendar convertToXMLGregorianCalendar(Date date) {
		if (date != null) {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			XMLGregorianCalendar gc = null;
			try {
				gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			} catch (Exception e) {
				logger.info("XML日期类型转换错误：", e);
			}
			return gc;
		} else {
			return null;
		}
	}
	
	/**
	 * xml格式日期转换
	 * @author 306566 chengjing
	 * @date 2018-04-22 下午4:48:43
	 */
	public static Date converToJavaDate(XMLGregorianCalendar cal){
		if (cal != null) {
			GregorianCalendar ca = cal.toGregorianCalendar();
			return ca.getTime();
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @Description: 获取制定日期前、后n天
	 * @author: xuexu
	 * @date: 2018-5-9 上午8:54:14
	 */
	public static Date getPreviousOrNextNDay(Date date,int n){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.add(Calendar.DATE, n);
		return gc.getTime();
	}
	
	/**
	 * 
	 * @Description: 将日期转化为String  “yyyy-MM-dd HH:mm”
	 * @author: xuexu
	 * @date: 2018-5-9 上午8:55:42
	 */
	public static final String convertDateToString(Date aDate, String pattern) {
		return getDateTime(pattern, aDate);
	}
	
	/**
	 * 
	 * @Description: 将日期格式化 “yyyy-MM-dd HH:mm”
	 * @author: xuexu
	 * @date: 2018-5-9 上午8:56:26
	 */
	public static final String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		} 
		return (returnValue);
	}
	
	/**
	 * 
	 * @Description: 获取两时间差
	 * @author: xuexu
	 * @date: 2018-5-9 上午9:10:44
	 */
	public static int daysBetween(String smdate,String bdate){
		Date date1,date2;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			date1=sdf.parse(smdate);
			date2=sdf.parse(bdate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(date2);
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
