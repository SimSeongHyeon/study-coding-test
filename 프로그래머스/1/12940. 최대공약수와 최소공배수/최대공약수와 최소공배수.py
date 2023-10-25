def solution(n, m):
    a = n
    b = m

    answer = []
    
    if b > a :
        temp = a
        a = b
        b = temp
        
    while b > 0 :
        r = a % b
        a = b
        b = r
        
    answer.append(a)
    answer.append(n * m // a)
    
    return answer