import java.util.*;


class Findbig {
    Pointer[] segment;
    int count;
    int terms;
    class Pointer{
        int x, y;

    };
    Findbig(int length , int firstx){
        segment = new Pointer[length];
        int count = length;
        terms = 0;
    }
    public void Newseg(int x, int y){
        if(terms == segment.length){
            segment = Arrays.copyOf(segment, segment.length+1);
        }
        segment[terms].x = x;
        segment[terms].y = y;
        terms++;
    }


    public Findbig compareAB(Findbig b){
        // set c length, first x
        int length, firstx;
        if(segment[0].x >= b.segment[0].x){
            if(segment[count].x >= b.segment[count].x){
                length = segment[count].x -b.segment[0].x;
                firstx = b.segment[0].x;
            }else{
                length = b.segment.length;
                firstx = b.segment[0].x;
            }
        }else{
            if(segment[count].x >= b.segment[count].x){
                length = segment.length;
                firstx = segment[0].x;
            }else{
                length = b.segment[count].x - segment[0].x;
                firstx = segment[0].x;
            }
        }
        Findbig c = new Findbig(length, firstx);

        int apos=0, bpos=0;
        // cal algorithm

        while((apos < count) && (bpos < b.count)){
            if(segment[apos].x > b.segment[bpos].x){
                c.Newseg(b.segment[bpos].x, b.segment[bpos].y);
                bpos++;
            }else if(segment[apos].x < b.segment[bpos].x){
                c.Newseg(segment[apos].x, segment[apos].y);
                apos++;
            }else{
                if(segment[apos].y >= b.segment[bpos].y){
                    c.Newseg(segment[apos].x, segment[apos].y);
                    apos++; bpos++;
                }else{
                    c.Newseg(segment[apos].x, segment[bpos].y);
                    apos++; bpos++;
                }
            }
        }

        
        for(; apos < count; apos++){
            c.Newseg(segment[apos].x, segment[apos].y);
        }
        for(; bpos < count; bpos++){
            c.Newseg(b.segment[bpos].x, b.segment[bpos].y);
        }
        return c;



    }
}
