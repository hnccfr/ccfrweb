/**
 * �����ַ���
 * 
 * @param nSize
 *            Ҫ����ĳ���
 * @param ch
 *            Ҫ������ַ�
 * @return
 */
String.prototype.padLeft = function(nSize, ch) {
	var len = 0;
	var s = this ? this : "";
	ch = ch ? ch : '0';// Ĭ�ϲ�0

	len = s.length;
	while (len < nSize) {
		s = ch + s;
		len++;
	}
	return s;
}

/**
 * �Ҳ����ַ���
 * 
 * @param nSize
 *            Ҫ����ĳ���
 * @param ch
 *            Ҫ������ַ�
 * @return
 */
String.prototype.padRight = function(nSize, ch) {
	var len = 0;
	var s = this ? this : "";
	ch = ch ? ch : '0';// Ĭ�ϲ�0

	len = s.length;
	while (len < nSize) {
		s = s + ch;
		len++;
	}
	return s;
}
/**
 * ����С����λ�ã�������ѧ���㣬�൱�ڳ���Math.pow(10,scale)��
 * 
 * @param scale
 *            Ҫ��λ�Ŀ̶�
 * @return
 */
String.prototype.movePointLeft = function(scale) {
	var s, s1, s2, ch, ps, sign;
	ch = '.';
	sign = '';
	s = this ? this : "";

	if (scale <= 0)
		return s;
	ps = s.split('.');
	s1 = ps[0] ? ps[0] : "";
	s2 = ps[1] ? ps[1] : "";
	if (s1.slice(0, 1) == '-') {
		s1 = s1.slice(1);
		sign = '-';
	}
	if (s1.length <= scale) {
		ch = "0.";
		s1 = s1.padLeft(scale);
	}
	return sign + s1.slice(0, -scale) + ch + s1.slice(-scale) + s2;
}
/**
 * ����С����λ�ã�������ѧ���㣬�൱�ڳ���Math.pow(10,scale)��
 * 
 * @param scale
 *            Ҫ��λ�Ŀ̶�
 * @return
 */
String.prototype.movePointRight = function(scale) {
	var s, s1, s2, ch, ps;
	ch = '.';
	s = this ? this : "";

	if (scale <= 0)
		return s;
	ps = s.split('.');
	s1 = ps[0] ? ps[0] : "";
	s2 = ps[1] ? ps[1] : "";
	if (s2.length <= scale) {
		ch = '';
		s2 = s2.padRight(scale);
	}
	return s1 + s2.slice(0, scale) + ch + s2.slice(scale, s2.length);
}
/**
 * �ƶ�С����λ�ã�������ѧ���㣬�൱�ڣ�����/���ԣ�Math.pow(10,scale)��
 * 
 * @param scale
 *            Ҫ��λ�Ŀ̶ȣ�������ʾ�����ƣ�������ʾ�����ƶ���0����ԭֵ��
 * @return
 */
String.prototype.movePoint = function(scale) {
	if (scale >= 0)
		return this.movePointRight(scale);
	else
		return this.movePointLeft(-scale);
}