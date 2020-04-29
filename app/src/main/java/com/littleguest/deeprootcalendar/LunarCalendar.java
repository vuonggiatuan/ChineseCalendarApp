package com.littleguest.deeprootcalendar;

/**
 * Created by Garfield on 2018/5/14.
 */

import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Created by loonggg on 2017/5/24.
 */

public class LunarCalendar {
    public static final int BASE_LAUNAR_YEAR = 1984;
    public static final String[] LUNAR_ANIMAL = {
            "鼠", "牛", "虎", "兔", "龍", "蛇", "馬", "羊", "猴", "雞", "狗", "猪"
    };
    public static final String[] CAN={
            "甲","乙","丙","丁","戊","已","庚","辛","壬","癸"
    };
    public static final String[] CHI={
            "子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"
    };

    public static final String[] HUANGDAORI= {
            "開日","閉日","建日","除日","滿日","平日","定日","執日","破日","危日","成日","收日"
    };
    public static final String[] XIAOHUANGDAORI= {
            "黃道青龍","黃道明堂","黑道天刑","黑道朱雀","黃道金匱","黃道寶光","黑道白虎","黃道玉堂","黑道天牢","黑道玄武","黃道司命","黑道勾陳"
    };
    public static final String[] HUANGDAORIYI={
            "嫁娶 納采 訂盟 祭祀 祈福 治病 造車器 修造 動土 移徙 入宅",
            "嫁娶 納采 訂盟 會親友 安機械 結網 冠笄 祭祀 求嗣 進人口 經絡",
            "祭祀 沐浴 移徙 破土 安葬 掃舍 平治道塗",
            "祭祀 祈福 齋醮 求嗣 安機械 納畜 移徙 入宅 安機械 塑繪 開光 起基 竪柱 上梁 作灶 安門 安香 出火 蓋屋 啓鑽 安葬",
            "嫁娶 納采 訂盟 齋醮 開光 祭祀 祈福 求醫 治病 會親友 動土 解除 捕捉 納畜 牧養 入殮 破土 安葬",
            "祭祀 沐浴 解除 破屋 壞垣 餘事勿取",
            "沐浴 掃舍 餘事勿取",
            "開市 交易 立券 安機械 會親友 開光 求醫 治病 蓋屋 起基 修造 動土 定磉 竪柱 上梁 安門 作灶 放水 開厠 開池 栽種 牧養 造畜稠 破土 安葬 立碑",
            "栽種 捕捉 畋獵 餘事勿取",
            "嫁娶 祭祀 祈福 求嗣 齋醮 訂盟 納采 解除 出行 動土 破土 習藝 針灸 理髮 會親友 起基 修造 動土 竪柱 定磉 安床 拆卸 納畜 牧養 放水 破土 除服 成服 修墳 立碑",
            "餘事勿取",
            "塞穴 斷蟻 結網 餘事勿取",
    };
    public static final String[] HUANGDAORIJI={
            "開市 出行 安床 作灶 安葬",
            "開市 作灶 動土 行喪 安葬",
            "祈福 嫁娶 入宅 安床 作灶",
            "動土 破土 嫁娶 嫁娶",
            "移徙 入宅 蓋屋 架馬",
            "行喪 安葬",
            "齋醮 開市 嫁娶 作灶",
            "嫁娶 出火 移徙 入宅",
            "開市 動土 祭祀 齋醮 安葬 探病",
            "開市 入宅 探病 出火 蓋屋",
            "餘事勿取",
            "破土 安葬",
    };
    public static final String[] LUNAR_YEAR_INFO = {
            "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "已巳", "庚午", "辛未", "壬申", "癸酉",
            "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "已卯", "庚辰", "辛巳", "壬午", "癸未",
            "甲申", "乙酉", "丙戌", "丁亥", "戊子", "已丑", "庚寅", "辛卯", "壬辰", "癸巳",
            "甲午", "乙未", "丙申", "丁酉", "戊戌", "已亥", "庚子", "辛丑", "壬寅", "癸卯",
            "甲辰", "乙巳", "丙午", "丁未", "戊申", "已酉", "庚戌", "辛亥", "壬子", "癸丑",
            "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "已未", "庚申", "辛酉", "壬戌", "癸亥"
    };

    public static final String[] LUNAR_MONTH_INFO = {
            "正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月",
            "十一月", "十二月"
    };

    public static final String[] LAUNAR_MONTH_DAY_INFO = {
            "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
            "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十",
            "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十",
    };

    /**
     * 支持转换的最小农历年份
     */
    public static final int MIN_YEAR = 1900;
    /**
     * 支持转换的最大农历年份
     */
    public static final int MAX_YEAR = 2099;

    /**
     * 公历每月前的天数
     */
    private static final int DAYS_BEFORE_MONTH[] = {0, 31, 59, 90, 120, 151, 181,
            212, 243, 273, 304, 334, 365};


    private static final int LUNAR_INFO[] = {
            0x84B6BF,/*1900*/
            0x04AE53, 0x0A5748, 0x5526BD, 0x0D2650, 0x0D9544, 0x46AAB9, 0x056A4D, 0x09AD42, 0x24AEB6, 0x04AE4A,/*1901-1910*/
            0x6A4DBE, 0x0A4D52, 0x0D2546, 0x5D52BA, 0x0B544E, 0x0D6A43, 0x296D37, 0x095B4B, 0x749BC1, 0x049754,/*1911-1920*/
            0x0A4B48, 0x5B25BC, 0x06A550, 0x06D445, 0x4ADAB8, 0x02B64D, 0x095742, 0x2497B7, 0x04974A, 0x664B3E,/*1921-1930*/
            0x0D4A51, 0x0EA546, 0x56D4BA, 0x05AD4E, 0x02B644, 0x393738, 0x092E4B, 0x7C96BF, 0x0C9553, 0x0D4A48,/*1931-1940*/
            0x6DA53B, 0x0B554F, 0x056A45, 0x4AADB9, 0x025D4D, 0x092D42, 0x2C95B6, 0x0A954A, 0x7B4ABD, 0x06CA51,/*1941-1950*/
            0x0B5546, 0x555ABB, 0x04DA4E, 0x0A5B43, 0x352BB8, 0x052B4C, 0x8A953F, 0x0E9552, 0x06AA48, 0x6AD53C,/*1951-1960*/
            0x0AB54F, 0x04B645, 0x4A5739, 0x0A574D, 0x052642, 0x3E9335, 0x0D9549, 0x75AABE, 0x056A51, 0x096D46,/*1961-1970*/
            0x54AEBB, 0x04AD4F, 0x0A4D43, 0x4D26B7, 0x0D254B, 0x8D52BF, 0x0B5452, 0x0B6A47, 0x696D3C, 0x095B50,/*1971-1980*/
            0x049B45, 0x4A4BB9, 0x0A4B4D, 0xAB25C2, 0x06A554, 0x06D449, 0x6ADA3D, 0x0AB651, 0x095746, 0x5497BB,/*1981-1990*/
            0x04974F, 0x064B44, 0x36A537, 0x0EA54A, 0x86B2BF, 0x05AC53, 0x0AB647, 0x5936BC, 0x092E50, 0x0C9645,/*1991-2000*/
            0x4D4AB8, 0x0D4A4C, 0x0DA541, 0x25AAB6, 0x056A49, 0x7AADBD, 0x025D52, 0x092D47, 0x5C95BA, 0x0A954E,/*2001-2010*/
            0x0B4A43, 0x4B5537, 0x0AD54A, 0x955ABF, 0x04BA53, 0x0A5B48, 0x652BBC, 0x052B50, 0x0A9345, 0x474AB9,/*2011-2020*/
            0x06AA4C, 0x0AD541, 0x24DAB6, 0x04B64A, 0x6a573D, 0x0A4E51, 0x0D2646, 0x5E933A, 0x0D534D, 0x05AA43,/*2021-2030*/
            0x36B537, 0x096D4B, 0xB4AEBF, 0x04AD53, 0x0A4D48, 0x6D25BC, 0x0D254F, 0x0D5244, 0x5DAA38, 0x0B5A4C,/*2031-2040*/
            0x056D41, 0x24ADB6, 0x049B4A, 0x7A4BBE, 0x0A4B51, 0x0AA546, 0x5B52BA, 0x06D24E, 0x0ADA42, 0x355B37,/*2041-2050*/
            0x09374B, 0x8497C1, 0x049753, 0x064B48, 0x66A53C, 0x0EA54F, 0x06AA44, 0x4AB638, 0x0AAE4C, 0x092E42,/*2051-2060*/
            0x3C9735, 0x0C9649, 0x7D4ABD, 0x0D4A51, 0x0DA545, 0x55AABA, 0x056A4E, 0x0A6D43, 0x452EB7, 0x052D4B,/*2061-2070*/
            0x8A95BF, 0x0A9553, 0x0B4A47, 0x6B553B, 0x0AD54F, 0x055A45, 0x4A5D38, 0x0A5B4C, 0x052B42, 0x3A93B6,/*2071-2080*/
            0x069349, 0x7729BD, 0x06AA51, 0x0AD546, 0x54DABA, 0x04B64E, 0x0A5743, 0x452738, 0x0D264A, 0x8E933E,/*2081-2090*/
            0x0D5252, 0x0DAA47, 0x66B53B, 0x056D4F, 0x04AE45, 0x4A4EB9, 0x0A4D4C, 0x0D1541, 0x2D92B5          /*2091-2099*/
    };

    /**
     * 将农历日期转换为公历日期
     *
     * @param year        农历年份
     * @param month       农历月
     * @param monthDay    农历日
     * @param isLeapMonth 该月是否是闰月
     *                    [url=home.php?mod=space&uid=7300]@return[/url] 返回农历日期对应的公历日期，year0, month1, day2.
     */
    public static final int[] lunarToSolar(int year, int month, int monthDay,
                                           boolean isLeapMonth) {
        int dayOffset;
        int leapMonth;
        int i;

        if (year < MIN_YEAR || year > MAX_YEAR || month < 1 || month > 12
                || monthDay < 1 || monthDay > 30) {
            throw new IllegalArgumentException(
                    "Illegal lunar date, must be like that:\n\t" +
                            "year : 1900~2099\n\t" +
                            "month : 1~12\n\t" +
                            "day : 1~30");
        }

        dayOffset = (LUNAR_INFO[year - MIN_YEAR] & 0x001F) - 1;

        if (((LUNAR_INFO[year - MIN_YEAR] & 0x0060) >> 5) == 2)
            dayOffset += 31;

        for (i = 1; i < month; i++) {
            if ((LUNAR_INFO[year - MIN_YEAR] & (0x80000 >> (i - 1))) == 0)
                dayOffset += 29;
            else
                dayOffset += 30;
        }

        dayOffset += monthDay;
        leapMonth = (LUNAR_INFO[year - MIN_YEAR] & 0xf00000) >> 20;

        // 这一年有闰月
        if (leapMonth != 0) {
            if (month > leapMonth || (month == leapMonth && isLeapMonth)) {
                if ((LUNAR_INFO[year - MIN_YEAR] & (0x80000 >> (month - 1))) == 0)
                    dayOffset += 29;
                else
                    dayOffset += 30;
            }
        }

        if (dayOffset > 366 || (year % 4 != 0 && dayOffset > 365)) {
            year += 1;
            if (year % 4 == 1)
                dayOffset -= 366;
            else
                dayOffset -= 365;
        }

        int[] solarInfo = new int[3];
        for (i = 1; i < 13; i++) {
            int iPos = DAYS_BEFORE_MONTH[i];
            if (year % 4 == 0 && i > 2) {
                iPos += 1;
            }

            if (year % 4 == 0 && i == 2 && iPos + 1 == dayOffset) {
                solarInfo[1] = i;
                solarInfo[2] = dayOffset - 31;
                break;
            }

            if (iPos >= dayOffset) {
                solarInfo[1] = i;
                iPos = DAYS_BEFORE_MONTH[i - 1];
                if (year % 4 == 0 && i > 2) {
                    iPos += 1;
                }
                if (dayOffset > iPos)
                    solarInfo[2] = dayOffset - iPos;
                else if (dayOffset == iPos) {
                    if (year % 4 == 0 && i == 2)
                        solarInfo[2] = DAYS_BEFORE_MONTH[i] - DAYS_BEFORE_MONTH[i - 1] + 1;
                    else
                        solarInfo[2] = DAYS_BEFORE_MONTH[i] - DAYS_BEFORE_MONTH[i - 1];

                } else
                    solarInfo[2] = dayOffset;
                break;
            }
        }
        solarInfo[0] = year;

        return solarInfo;
    }

    /**
     * 将公历日期转换为农历日期，且标识是否是闰月
     *
     * @param year
     * @param month
     * @param monthDay
     * @return 返回公历日期对应的农历日期，year0，month1，day2，leap3
     */
    public static final int[] solarToLunar(int year, int month, int monthDay) {
        int[] lunarDate = new int[4];
        Date baseDate = new GregorianCalendar(1900, 0, 31).getTime();
        Date objDate = new GregorianCalendar(year, month - 1, monthDay).getTime();
        int offset = (int) ((objDate.getTime() - baseDate.getTime()) / 86400000L);

        // 用offset减去每农历年的天数计算当天是农历第几天
        // iYear最终结果是农历的年份, offset是当年的第几天
        int iYear, daysOfYear = 0;
        for (iYear = MIN_YEAR; iYear <= MAX_YEAR && offset > 0; iYear++) {
            daysOfYear = daysInLunarYear(iYear);
            offset -= daysOfYear;
        }
        if (offset < 0) {
            offset += daysOfYear;
            iYear--;
        }

        // 农历年份
        lunarDate[0] = iYear;

        int leapMonth = leapMonth(iYear); // 闰哪个月,1-12
        boolean isLeap = false;
        // 用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天
        int iMonth, daysOfMonth = 0;
        for (iMonth = 1; iMonth <= 13 && offset > 0; iMonth++) {
            daysOfMonth = daysInLunarMonth(iYear, iMonth);
            offset -= daysOfMonth;
        }
        // 当前月超过闰月，要校正
        if (leapMonth != 0 && iMonth > leapMonth) {
            --iMonth;

            if (iMonth == leapMonth) {
                isLeap = true;
            }
        }
        // offset小于0时，也要校正
        if (offset < 0) {
            offset += daysOfMonth;
            --iMonth;
        }

        lunarDate[1] = iMonth;
        lunarDate[2] = offset + 1;
        lunarDate[3] = isLeap ? 1 : 0;

        return lunarDate;
    }

    /**
     * 传回农历year年month月的总天数
     *
     * @param year  要计算的年份
     * @param month 要计算的月
     * @return 传回天数
     */
    final public static int daysInMonth(int year, int month) {
        return daysInMonth(year, month, false);
    }

    /**
     * 传回农历year年month月的总天数
     *
     * @param year  要计算的年份
     * @param month 要计算的月
     * @param leap  当月是否是闰月
     * @return 传回天数，如果闰月是错误的，返回0.
     */
    public static final int daysInMonth(int year, int month, boolean leap) {
        int leapMonth = leapMonth(year);
        int offset = 0;

        // 如果本年有闰月且month大于闰月时，需要校正
        if (leapMonth != 0 && month > leapMonth) {
            offset = 1;
        }

        // 不考虑闰月
        if (!leap) {
            return daysInLunarMonth(year, month + offset);
        } else {
            // 传入的闰月是正确的月份
            if (leapMonth != 0 && leapMonth == month) {
                return daysInLunarMonth(year, month + 1);
            }
        }

        return 0;
    }

    /**
     * 传回农历 year年的总天数
     *
     * @param year 将要计算的年份
     * @return 返回传入年份的总天数
     */
    private static int daysInLunarYear(int year) {
        int i, sum = 348;
        if (leapMonth(year) != 0) {
            sum = 377;
        }
        int monthInfo = LUNAR_INFO[year - MIN_YEAR] & 0x0FFF80;
        for (i = 0x80000; i > 0x7; i >>= 1) {
            if ((monthInfo & i) != 0)
                sum += 1;
        }
        return sum;
    }

    /**
     * 传回农历 year年month月的总天数，总共有13个月包括闰月
     *
     * @param year  将要计算的年份
     * @param month 将要计算的月份
     * @return 传回农历 year年month月的总天数
     */
    private static int daysInLunarMonth(int year, int month) {
        if ((LUNAR_INFO[year - MIN_YEAR] & (0x100000 >> month)) == 0)
            return 29;
        else
            return 30;
    }

    /**
     * 传回农历 year年闰哪个月 1-12 , 没闰传回 0
     *
     * @param year 将要计算的年份
     * @return 传回农历 year年闰哪个月1-12, 没闰传回 0
     */
    private static int leapMonth(int year) {
        return (int) ((LUNAR_INFO[year - MIN_YEAR] & 0xF00000)) >> 20;
    }

    /**
     * 返回农历
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getLunarYearMonthDay(int year, int month, int day) {
        String lunarYear = "", lunarMonth = "", lunarDay = "", animal = "";
        int[] lunar = solarToLunar(year, month, day);
        if (lunar[0] >= BASE_LAUNAR_YEAR) {
            int d = lunar[0] - BASE_LAUNAR_YEAR;
            lunarYear = LUNAR_YEAR_INFO[d % 60];
            animal = LUNAR_ANIMAL[d % 12];
        } else {
            int d = BASE_LAUNAR_YEAR - lunar[0];
            lunarYear = LUNAR_YEAR_INFO[60 - (d % 60 == 0 ? 60 : d % 60)];
            animal = LUNAR_ANIMAL[12 - (d % 12 == 0 ? 12 : d % 12)];
        }
        lunarMonth = LUNAR_MONTH_INFO[lunar[1] - 1];
        lunarDay = LAUNAR_MONTH_DAY_INFO[lunar[2] - 1];
        return lunarYear + animal + "年" + lunarMonth + lunarDay;
    }

    /**
     * 只返回农历的年
     *
     * @param year
     * @param month
     * @param day
     * @param isNumber 返回是否是农历的天干地支的年分，还是数字年
     * @return
     */
    public static String getLunarYear(int year, int month, int day, boolean isNumber) {
        String lunarYear = "";
        int[] lunar = solarToLunar(year, month, day);
        if (!isNumber) {
            if (lunar[0] >= BASE_LAUNAR_YEAR) {
                int d = lunar[0] - BASE_LAUNAR_YEAR;
                lunarYear = LUNAR_YEAR_INFO[d % 60];
            } else {
                int d = BASE_LAUNAR_YEAR - lunar[0];
                lunarYear = LUNAR_YEAR_INFO[60 - (d % 60 == 0 ? 60 : d % 60)];
            }
        } else {
            lunarYear = lunar[0] + "";
        }

        return lunarYear;
    }

    /**
     * 返回农历月日
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getLunarMonthDay(int year, int month, int day) {
        String lunarMonth = "", lunarDay = "";
        int[] lunar = solarToLunar(year, month, day);
        lunarMonth = LUNAR_MONTH_INFO[lunar[1] - 1];
        lunarDay = LAUNAR_MONTH_DAY_INFO[lunar[2] - 1];
        return lunarMonth + lunarDay;
    }

    public static Integer getLunarMonth(int year, int month, int day) {
        Integer mon;
        int[] lunar = solarToLunar(year, month, day);
        mon = lunar[1] - 1;
        return mon;
    }

    /**
     * 返回农历生肖
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getLunarAnimal(int year, int month, int day) {
        String animal = "";
        int[] lunar = solarToLunar(year, month, day);
        if (lunar[0] >= BASE_LAUNAR_YEAR) {
            int d = lunar[0] - BASE_LAUNAR_YEAR;

            animal = LUNAR_ANIMAL[d % 12];
        } else {
            int d = BASE_LAUNAR_YEAR - lunar[0];

            animal = LUNAR_ANIMAL[12 - (d % 12 == 0 ? 12 : d % 12)];
        }
        return animal;
    }

    public static String getCAN(int year, int month, int day){
        String can="";
        int[] lunar = solarToLunar(year, month, day);
        if (lunar[0] >= BASE_LAUNAR_YEAR) {
            int d = lunar[0] - BASE_LAUNAR_YEAR;

            can = CAN[d % 10];
        } else {
            int d = BASE_LAUNAR_YEAR - lunar[0];

            can = LUNAR_ANIMAL[10 - (d % 10 == 0 ? 10 : d % 10)];
        }
        return can;
    }

    public static double showSolarLongitude(int dd,int mm,int yy,int hour,int minute) {
        double jd = jdAtVST(dd, mm, yy, hour, minute);
        double sl = solarLongitude(jd);
        return (sl)%360;
    }

    public static double jdAtVST(int dd,int mm,int yy,int hour,int minutes) {
        double ret = jdn(dd, mm, yy);
        return ret - 0.5 + (hour-7)/24.0 + minutes/1440.0 ;
    }

    public static double jdn(int dd,int mm,int yy) {
        int a = ((14 - mm) / 12);
        int y = yy+4800-a;
        int m = mm+12*a-3;
        int jd = dd + ((153*m+2)/5) + 365*y + (y/4) - (y/100) + (y/400) - 32045;
        if (jd < 2299161) {
            jd = dd + ((153*m+2)/5) + 365*y + (y/4) - 32083;
        }
        return jd;
    }

    public static double solarLongitude(double jd) {
        double T, T2, dr, M, L0, C, lambda, theta, omega;
        T = (jd - 2451545.0 ) / 36525; // Time in Julian centuries from 2000-01-01 12:00:00 GMT
        T2 = T*T;
        dr = Math.PI/180; // degree to radian
        // mean anomaly, degree
        M = 357.52910 + 35999.05030*T - 0.0001559*T2 - 0.00000048*T*T2;
        // mean longitude, degree
        L0 = 280.46645 + 36000.76983*T + 0.0003032*T2;
        // Sun's equation of center
        C = (1.914600 - 0.004817*T - 0.000014*T2)*Math.sin(dr*M);
        C = C + (0.019993 - 0.000101*T)*Math.sin(dr*2*M) + 0.000290*Math.sin(dr*3*M);
        theta = L0 + C; // true longitude, degree
        // obtain apparent longitude by correcting for nutation and aberration
        omega = 125.04 - 1934.136 * T;
        lambda = theta - 0.00569 - 0.00478 * Math.sin(omega * dr);
        // Normalize to (0, 360)
        lambda = lambda - 360*((int)(lambda/360)); // Normalize to (0, 2*PI)
        return lambda;
    }

    public static String getJieQi(double angle){
        if(angle<15){ return "春分";}
        else if(angle<30){ return "清明";}
        else if(angle<45){ return "穀雨";}
        else if(angle<60){ return "立夏";}
        else if(angle<240){ return "立冬";}
        else if(angle<255){ return "小雪";}
        else if(angle<270){ return "大雪";}
        else if(angle<285){ return "冬至";}
        else if(angle<300){ return "小寒";}
        else if(angle<315){ return "大寒";}
        else if(angle<330){ return "立春";}
        else if(angle<345){ return "雨水";}
        else if(angle<360){ return "驚蟄";}
        else return "";
    }

    public static String getDayCan(int year,int month,int day) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, day);
        gc.set(GregorianCalendar.MONTH, month-1);
        gc.set(GregorianCalendar.YEAR, year);
        int dayofyear=gc.get(GregorianCalendar.DAY_OF_YEAR);
        int can=(((year-1)*5+(year-1)/4+dayofyear)%60)%10;
        return CAN[can-1];
    }

    public static Integer getDayChiNum(int year,int month,int day) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, day);
        gc.set(GregorianCalendar.MONTH, month-1);
        gc.set(GregorianCalendar.YEAR, year);
        int dayofyear=gc.get(GregorianCalendar.DAY_OF_YEAR);
        int chi=(((year-1)*5+(year-1)/4+dayofyear)%60)%12;
        return chi-1;
    }

    public static String getDayChi(int year,int month,int day) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(GregorianCalendar.DAY_OF_MONTH, day);
        gc.set(GregorianCalendar.MONTH, month-1);
        gc.set(GregorianCalendar.YEAR, year);
        int dayofyear=gc.get(GregorianCalendar.DAY_OF_YEAR);
        int chi=(((year-1)*5+(year-1)/4+dayofyear)%60)%12;
        return CHI[chi-1];
    }

    public static String getHuangDaoRi(int DayChi, int Month) {
        int huangdaori=(DayChi+12-Month)%12;
        return HUANGDAORI[huangdaori];
    }

    public static String getXiaoHuangDaoRi(int DayChi, int Month) {
        int xiaohuangdaori;

        if(Month>=6) {Month=Month%12;}
        xiaohuangdaori=(DayChi-Month*2);
        if(xiaohuangdaori<0) {
            xiaohuangdaori=xiaohuangdaori+24;
        }
        return XIAOHUANGDAORI[xiaohuangdaori%12];
    }

    public static String getYi(int DayChi, int Month){
        int yi;

        if(Month>=6) {Month=Month%12;}
        yi=(DayChi-Month*2);
        if(yi<0) {
            yi=yi+24;
        }
        return HUANGDAORIYI[yi%12];
    }

    public static String getJi(int DayChi, int Month){
        int ji;

        if(Month>=6) {Month=Month%12;}
        ji=(DayChi-Month*2);
        if(ji<0) {
            ji=ji+24;
        }
        return HUANGDAORIJI[ji%12];
    }

}

