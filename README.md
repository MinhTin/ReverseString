# ReverseString
Reverse String Testing 
1.1. Đọc tập tin input.txt. Chuẩn hóa các xâu thành dạng xâu chỉ gồm chữ hoa và số (loại bỏ dấu cách nếu có). In ra tệp tin bai3_1.out có N dòng, 2 cột (phân cách giữa 2 cột bằng dấu “;”). Cột 1 là xâu kết quả được chuẩn hóa tương ứng với xâu trong tệp tin input.txt. Cột 2 in giá trị: “TRUE” nếu xâu là xâu đối xứng, “FALSE” nếu xâu không phải xâu đối xứng. <br/>

1.2. In ra tệp tin bai3_2.out gồm N dòng, 3 cột (phân cách giữa 2 cột bằng dấu “;”). Cột 1 là xâu kết quả được chuẩn hóa tương ứng với xâu trong tệp tin input.txt. Cột 2 in ra xâu con là xâu đối xứng có chiều dài lớn nhất, nếu không tìm thấy xâu con nào đối xứng thì in ra NULL. Cột 3 in ra chiều dài xâu con là xâu đối xứng, nếu không có xâu con nào đối xứng thì in ra giá trị “0”. <br/>

1.3. Với mỗi xâu S không phải xâu đối xứng trong N xâu đọc từ tập tin input.txt, thực hiện thao xóa (delete) không quá L/2 ký tự liền nhau trong xâu S (L là chiều dài xâu không đối xứng S) để tạo thành một xâu đối xứng và in ra tệp tin bai3_3.out. Tệp tin bai3_3.out gồm N dòng, 2 cột (phân cách giữa 2 cột bằng dấu “;”). Cột 1 là xâu kết quả được chuẩn hóa tương ứng với xâu trong tệp tin input.txt. Cột 2, nếu xâu gốc đã là xâu đối xứng thì in “OK”, nếu xâu gốc không phải xâu đối xứng thì in ra xâu đối xứng được tạo từ xâu gốc và thao tác delete ở trên, nếu không thể tạo được xâu đối xứng mới thì in ra “NOK”. <br/>

#Clone Project <br/>
Import Project into Eclipse   <br/>
Using JAVA 8 or higher . <br/>
Change properties.ini for Testing .  <br/>

#RESULT 
Input : <br/>
1221 <br/>
Eye <br/>
Abcdefghijklmn <br/>
Madam radar A1234567887654321A <br/>
abcdeFghijklm <br/>
2301234432132 <br/>
230132441032 <br/>

Question 1 :  <br/>
1221;TRUE  <br/>
EYE;TRUE <br/>
ABCDEFGHIJKLMN;FALSE <br/>
MADAMRADARA1234567887654321A;FALSE <br/>
ABCDEFGHIJKLM;FALSE <br/>
2301234432132;FALSE <br/>
230132441032;FALSE <br/>

Question 2 : <br/>
1221;22;2  <br/>
EYE;NULL;0 <br/>
ABCDEFGHIJKLMN;NULL;0 <br/>
MADAMRADARA1234567887654321A;A1234567887654321A;18 <br/>
ABCDEFGHIJKLM;NULL;0 <br/>
2301234432132;12344321;8 <br/>
230132441032;44;2 <br/>

Question 3 : <br/>
1221;OK <br/>
EYE;OK <br/>
ABCDEFGHIJKLMN;NOK <br/>
MADAMRADARA1234567887654321A;A1234567887654321A;18 <br/>
ABCDEFGHIJKLM;NOK <br/>
2301234432132;3123443213;10 <br/>
230132441032;3014103;7 <br/>

