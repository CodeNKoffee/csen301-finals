package eleven;

class ExerciseOne {
  public static boolean binarySearch(int[] arr, int v) {
    int min = 0;
    int max = arr.length - 1;
    int mid;

    while (max >= min) {
      mid = min + ((max - min) / 2);
      if (arr[mid] == v)
        return true;
      else if (arr[mid] > v) 
        max = mid - 1;
      else 
        min = mid + 1;
    }
    return false;
  }
}